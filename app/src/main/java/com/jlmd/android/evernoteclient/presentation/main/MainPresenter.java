package com.jlmd.android.evernoteclient.presentation.main;

import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.main.MainActivity;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class MainPresenter extends Presenter<MainActivity> {

  private final Navigator navigator;
  private final EvernoteSession evernoteSession;

  public MainPresenter(Navigator navigator, EvernoteSession evernoteSession) {
    this.navigator = navigator;
    this.evernoteSession = evernoteSession;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    checkUserLogged();
  }

  private void checkUserLogged() {
    if (isUserLogged()) {
      navigator.goToNotesList();
    } else {
      navigator.goToLogin();
    }
  }

  private boolean isUserLogged() {
    return evernoteSession.isLoggedIn();
  }
}
