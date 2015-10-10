package com.jlmd.android.evernoteclient.presentation.notedetails;

import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.notedetails.NoteDetailsActivity;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class NoteDetailsPresenter extends Presenter<NoteDetailsActivity> {

  private final Navigator navigator;

  public NoteDetailsPresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  public void onBackPressed() {
    navigator.goBackToNotesList();
  }

  public void onNoteReceived(Note note) {
    view.renderNote(note);
  }
}