package com.jlmd.android.evernoteclient.domain.interactor.login;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.domain.interactor.AbstractInteractor;
import com.jlmd.android.evernoteclient.domain.model.Credentials;
import com.jlmd.android.evernoteclient.domain.repository.CredentialsRepository;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.EvernoteApi;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * @author jlmd
 */
public class Login extends AbstractInteractor {

  private static final String CONSUMER_KEY = "jlmartind";
  private static final String CONSUMER_SECRET = "7222fd3698ed371a";
  private static final String CALLBACK_URL = "evernoteandroidclient://";
  private final Navigator navigator;
  private final CredentialsRepository credentialsRepository;
  private Callback callback;
  private OAuthService oAuthService;
  private Token requestToken;
  private String oauthVerifier;

  public Login(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor,
      Navigator navigator, CredentialsRepository credentialsRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.navigator = navigator;
    this.credentialsRepository = credentialsRepository;
  }

  public void doLogin(Callback callback) {
    this.callback = callback;
    executeCurrentInteractor();
  }

  public void obtainAccessToken(String oauthVerifier) {
    this.oauthVerifier = oauthVerifier;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    if (oauthVerifier == null) {
      navigator.openWebsite(generateAuthUrl());
    } else {
      requestAccessToken();
    }
  }

  private void requestAccessToken() {
    Verifier verifier = new Verifier(oauthVerifier);
    try {
      Token accessToken =
          oAuthService.getAccessToken(requestToken, verifier);
      credentialsRepository.setCredentials(new Credentials(accessToken.getToken()));
      doSuccess();
    } catch (Exception e) {
      doError(e);
    }
  }

  public String generateAuthUrl() {
    oAuthService = new ServiceBuilder().provider(EvernoteApi.Sandbox.class)
        .apiKey(CONSUMER_KEY)
        .apiSecret(CONSUMER_SECRET)
        .callback(CALLBACK_URL)
        .build();
    requestToken = oAuthService.getRequestToken();
    return oAuthService.getAuthorizationUrl(requestToken);
  }

  private void doSuccess() {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onLogged();
      }
    });
  }

  private void doError(final Throwable throwable) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onError(throwable);
      }
    });
  }

  public interface Callback {

    void onLogged();

    void onError(Throwable throwable);
  }
}
