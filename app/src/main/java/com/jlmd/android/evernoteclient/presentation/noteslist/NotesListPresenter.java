package com.jlmd.android.evernoteclient.presentation.noteslist;

import android.util.Log;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.noteslist.view.NotesListActivity;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListPresenter extends Presenter<NotesListActivity> {

  private final GetNotesList getNotesList;
  private final Navigator navigator;
  private List<Note> notes;

  public NotesListPresenter(GetNotesList getNotesList, Navigator navigator) {
    this.getNotesList = getNotesList;
    this.navigator = navigator;
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

  public void onItemClicked(int position) {
    navigator.goToNoteDetails(notes.get(position));
  }

  public void onAddItemClick() {
    navigator.goToAddNote();
  }

  private class NotesListCallback implements GetNotesList.Callback {

    @Override
    public void onSuccess(List<Note> notes) {
      setNotebookList(notes);
      view.renderNotes(notes);
    }

    @Override
    public void onError(Throwable throwable) {
      // TODO Call the view to show an error
      Log.e("NotesListPresenter", "Error obtaining note list", throwable);
    }
  }
}
