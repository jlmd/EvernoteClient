package com.jlmd.android.evernoteclient.presentation.login;

import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class LoginPresenter extends Presenter<LoginActivity> {

  private final Navigator navigator;

  public LoginPresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onLoginButtonPressed() {
    navigator.openLoginWebsite();
  }

  public void onLoggedOk() {
    // TODO Store credentials in shared preferences or something...
    navigator.goToNotesList();
  }

  public void onLoginFailure() {
    view.showError();
  }
}
