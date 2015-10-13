package com.jlmd.android.evernoteclient.domain.interactor.noteslist;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.data.repository.NoteRepository;
import com.jlmd.android.evernoteclient.domain.interactor.AbstractInteractor;
import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.List;

/**
 * @author jlmd
 */
public class GetNotesList extends AbstractInteractor {

  private final NoteRepository noteRepository;
  private Callback callback;

  public GetNotesList(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor,
      NoteRepository noteRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.noteRepository = noteRepository;
  }

  public void getNotesList(Callback callback) {
    this.callback = callback;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    try {
      List<Note> notes = noteRepository.getNotes();
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
