package com.jlmd.android.evernoteclient.presentation.noteslist;

import android.util.Log;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.jlmd.android.evernoteclient.app.ui.noteslist.NotesListActivity;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListPresenter extends Presenter<NotesListActivity> {

  private final GetNotesList getNotesList;
  private List<Note> notes;

  public NotesListPresenter(GetNotesList getNotesList) {
    this.getNotesList = getNotesList;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    obtainNotes();
  }

  private void obtainNotes() {
    getNotesList.getNotesList(new NotesListCallback());
  }

  private void setNotebookList(List<Note> notes) {
    this.notes = notes;
  }

  private class NotesListCallback implements GetNotesList.Callback {

    @Override
    public void onSuccess(List<Note> notebooks) {
      Log.e("NotesListPresenter", "Note books size: " + notebooks.size());
      setNotebookList(notebooks);
    }

    @Override
    public void onError(Throwable throwable) {
      Log.e("NotesListPresenter", "Error obtaining note list", throwable);
    }
  }
}
