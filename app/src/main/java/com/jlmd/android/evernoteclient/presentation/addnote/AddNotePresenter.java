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

  private final AddNote addNote;
  private final Navigator navigator;

  public AddNotePresenter(Navigator navigator, AddNote addNote) {
    this.addNote = addNote;
    this.navigator = navigator;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Note note = new Note();
    note.setTitle("testing add note4");
    note.setContent(NoteContentParser.getContentText("asda"));
    note.setCreated(3434l);
    addNote.addNote(note, new AddNote.Callback() {
      @Override
      public void onSuccess() {
        Log.i("ASD", "Done");
      }

      @Override
      public void onError(Throwable throwable) {
        Log.e("ASD", "Error", throwable);
      }
    });
  }
}
