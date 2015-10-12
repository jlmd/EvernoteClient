package com.jlmd.android.evernoteclient.presentation.noteslist;

import android.util.Log;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.noteslist.view.NotesListActivity;
import com.jlmd.android.evernoteclient.domain.comparator.NoteDateComparator;
import com.jlmd.android.evernoteclient.domain.comparator.NoteTitleComparator;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import java.util.Collections;
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
  public void onResume() {
    super.onResume();
    obtainNotes();
  }

  private void obtainNotes() {
    view.showLoading();
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

  public void sortNotesByTitle() {
    Collections.sort(notes, new NoteTitleComparator());
    updateNotesView();
  }

  public void sortNotesByDate() {
    Collections.sort(notes, new NoteDateComparator());
    updateNotesView();
  }

  private void updateNotesView() {
    view.renderNotes(notes);
  }

  private class NotesListCallback implements GetNotesList.Callback {

    @Override
    public void onSuccess(List<Note> notes) {
      view.hideLoading();
      setNotebookList(notes);
      updateNotesView();
    }

    @Override
    public void onError(Throwable throwable) {
      view.hideLoading();
      // TODO Call the view to show an error
      Log.e("NotesListPresenter", "Error obtaining note list", throwable);
    }
  }
}
