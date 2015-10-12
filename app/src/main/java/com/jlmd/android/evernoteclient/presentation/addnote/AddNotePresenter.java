package com.jlmd.android.evernoteclient.presentation.addnote;

import android.graphics.Bitmap;
import android.util.Log;
import com.googlecode.tesseract.android.TessBaseAPI;
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
  private final TessBaseAPI tessBaseAPI;

  public AddNotePresenter(Navigator navigator, AddNote addNote, TessBaseAPI tessBaseAPI) {
    this.addNote = addNote;
    this.navigator = navigator;
    this.tessBaseAPI = tessBaseAPI;
  }

  public void onSaveNoteClick(String title, String author, String content) {
    view.showLoading();
    Note note = new Note(title, author, NoteContentParser.getContentText(content));
    addNote.addNote(note, new AddNoteCallback());
  }

  public void onBackPressed() {
    navigator.goBackToNotesList();
  }

  public void onDrawTextClick() {
    view.showDrawPanel();
  }

  public void onBitmapCreated(Bitmap bitmap) {
    tessBaseAPI.setImage(bitmap);
    String recognizedText = tessBaseAPI.getUTF8Text();
    view.setTextOnFocusedElement(recognizedText);
  }

  private class AddNoteCallback implements AddNote.Callback {

    @Override
    public void onSuccess() {
      Log.i(TAG, "Note saved successfully");
      view.hideLoading();
      navigator.goBackToNotesList();
    }

    @Override
    public void onError(Throwable throwable) {
      Log.e(TAG, "Error saving note", throwable);
      view.showUnexpectedError();
    }
  }
}
