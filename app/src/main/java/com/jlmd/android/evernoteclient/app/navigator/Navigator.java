package com.jlmd.android.evernoteclient.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.ui.addnote.AddNoteActivity;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import com.jlmd.android.evernoteclient.app.ui.notedetails.NoteDetailsActivity;
import com.jlmd.android.evernoteclient.app.ui.noteslist.view.NotesListActivity;
import com.jlmd.android.evernoteclient.domain.model.Note;

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

  public void goToNoteDetails(Note note) {
    finishCurrentActivity();
    Intent intent = new Intent(activity, NoteDetailsActivity.class);
    Bundle bundle = new Bundle();
    bundle.putParcelable(NoteDetailsActivity.NOTE_KEY, note);
    intent.putExtras(bundle);
    activity.overridePendingTransition(R.anim.animation_enter_right, R.anim.animation_leave_right);
    activity.startActivity(intent);
  }

  public void goBackToNotesList() {
    finishCurrentActivity();
    Intent intent = new Intent(activity, NotesListActivity.class);
    activity.overridePendingTransition(R.anim.animation_enter_left, R.anim.animation_leave_left);
    activity.startActivity(intent);
  }

  public void goToAddNote() {
    finishCurrentActivity();
    Intent intent = new Intent(activity, AddNoteActivity.class);
    activity.overridePendingTransition(R.anim.animation_enter_right, R.anim.animation_leave_right);
    activity.startActivity(intent);
  }

  private void finishCurrentActivity() {
    activity.finish();
  }
}
