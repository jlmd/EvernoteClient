package com.jlmd.android.evernoteclient.presentation.addnote;

import android.util.Log;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.addnote.AddNoteActivity;
import com.jlmd.android.evernoteclient.domain.interactor.addnote.AddNote;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.domain.parser.NoteContentParser;
import com.jlmd.android.evernoteclient.presentation.Presenter;

/**
 * @author jlmd
 */
public class AddNotePresenter extends Presenter<AddNoteActivity> {

  private static final String TAG = AddNotePresenter.class.getSimpleName();
  private final AddNote addNote;
  private final Navigator navigator;

  public AddNotePresenter(Navigator navigator, AddNote addNote) {
    this.addNote = addNote;
    this.navigator = navigator;
  }

  public void saveNote(String title, String author, String content) {
    Note note = new Note(title, author, NoteContentParser.getContentText(content));
    addNote.addNote(note, new AddNoteCallback());
  }

  public void onBackPressed() {
    navigator.goBackToNotesList();
  }

  private class AddNoteCallback implements AddNote.Callback {

    @Override
    public void onSuccess() {
      Log.i(TAG, "Note saved successfully");
      navigator.goBackToNotesList();
    }

    @Override
    public void onError(Throwable throwable) {
      Log.e(TAG, "Error saving note", throwable);
      // TODO Show error
    }
  }
}
