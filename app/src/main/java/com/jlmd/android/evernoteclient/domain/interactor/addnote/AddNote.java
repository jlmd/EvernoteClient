package com.jlmd.android.evernoteclient.domain.interactor.addnote;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.data.repository.NoteRepository;
import com.jlmd.android.evernoteclient.domain.interactor.AbstractInteractor;
import com.jlmd.android.evernoteclient.domain.model.Note;

/**
 * @author jlmd
 */
public class AddNote extends AbstractInteractor {

  private final NoteRepository noteRepository;
  private Callback callback;
  private Note note;

  public AddNote(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor,
      NoteRepository noteRepository) {
    super(interactorExecutor, mainThreadExecutor);
    this.noteRepository = noteRepository;
  }

  public void addNote(Note note, Callback callback) {
    this.note = note;
    this.callback = callback;
    executeCurrentInteractor();
  }

  @Override
  public void run() {
    try {
      noteRepository.addNote(note);
      doSuccess();
    } catch (Exception e) {
      doError(e);
    }
  }

  private void doSuccess() {
    executeInMainThread(new Runnable() {
      @Override
      public void run() {
        callback.onSuccess();
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

    void onSuccess();

    void onError(Throwable throwable);
  }
}
