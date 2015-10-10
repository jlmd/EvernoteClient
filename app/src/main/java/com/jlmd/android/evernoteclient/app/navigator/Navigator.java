package com.jlmd.android.evernoteclient.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import com.jlmd.android.evernoteclient.app.ui.noteslist.NotesListActivity;

/**
 * @author jlmd
 */
public class Navigator {

  private Activity activity;
  private EvernoteSession evernoteSession;

  public Navigator(EvernoteSession evernoteSession) {
    this.evernoteSession = evernoteSession;
  }

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public void openWebsite(String url) {
    Uri uri = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    activity.startActivity(intent);
  }

  public void goToLogin() {
    finishCurrentActivity();
    Intent intent = new Intent(activity, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    activity.startActivity(intent);
  }

  public void goToNotesList() {
    finishCurrentActivity();
    Intent intent = new Intent(activity, NotesListActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    activity.startActivity(intent);
  }

  public void openLoginWebsite() {
    evernoteSession.authenticate(activity);
  }

  private void finishCurrentActivity() {
    activity.finish();
  }
}
