package com.jlmd.android.evernoteclient.presentation.main;

import android.util.Log;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.main.MainActivity;
import com.jlmd.android.evernoteclient.domain.repository.CredentialsRepository;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class MainPresenter extends Presenter<MainActivity> {

  private final CredentialsRepository credentialsRepository;
  private final Navigator navigator;

  public MainPresenter(CredentialsRepository credentialsRepository, Navigator navigator) {
    this.credentialsRepository = credentialsRepository;
    this.navigator = navigator;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    checkUserLogged();
  }

  private void checkUserLogged() {
    if (isUserLogged()) {
      Log.i("MainPresenter", "User logged already!");
      Log.i("MainPresenter",
          "Access token: " + credentialsRepository.getCredentials().getAccessToken());
    } else {
      navigator.goToLogin();
    }
  }

  private boolean isUserLogged() {
    return credentialsRepository.getCredentials() != null;
  }
}
