package com.jlmd.android.evernoteclient.presentation.login;

import android.util.Log;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import com.jlmd.android.evernoteclient.domain.interactor.login.Login;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class LoginPresenter extends Presenter<LoginActivity> {

  private static final String TAG = LoginPresenter.class.getSimpleName();
  private final Login login;

  public LoginPresenter(Login login) {
    this.login = login;
  }

  public void onLoginButtonPressed() {
    login.doLogin(new LoginCallback());
  }

  private class LoginCallback implements Login.Callback {

    @Override
    public void onLogged() {
      Log.i(TAG, "Logged successful!");
    }

    @Override
    public void onError(Throwable throwable) {
      Log.e(TAG, "Login error", throwable);
      view.showError();
    }
  }
}
