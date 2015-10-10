package com.jlmd.android.evernoteclient.domain.interactor.noteslist;

import com.evernote.edam.type.Note;
import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.data.repository.NotesListRepository;
import com.jlmd.android.evernoteclient.domain.interactor.AbstractInteractor;
import java.util.List;

/**
 * @author jlmd
 */
public class GetNotesList extends AbstractInteractor {

  private final NotesListRepository notesListRepository;
  private Callback callback;

  public GetNotesList(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor,
      NotesListRepository notesListRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.notesListRepository = notesListRepository;
  }

  public void getNotesList(Callback callback) {
    this.callback = callback;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    try {
      List<Note> notes = notesListRepository.getNotes();
      doSuccess(notes);
    } catch (Exception e) {
      doError(e);
    }
  }

  private void doSuccess(final List<Note> notes) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess(notes);
      }
    });
  }

  private void doError(final Throwable throwable) {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onError(throwable);
      }
    });
  }

  public interface Callback {

    void onSuccess(List<Note> notebooks);

    void onError(Throwable throwable);
  }
}
