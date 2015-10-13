package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.data.repository.NoteRepository;
import com.jlmd.android.evernoteclient.domain.interactor.addnote.AddNote;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module which provides interactors (use cases)
 *
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class InteractorModule {

  @Provides
  @Singleton
  GetNotesList provideGetNotesList(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, NoteRepository noteRepository) {
    return new GetNotesList(interactorExecutor, mainThreadExecutor, noteRepository);
  }

  @Provides
  @Singleton
  AddNote provideAddNote(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, NoteRepository noteRepository) {
    return new AddNote(interactorExecutor, mainThreadExecutor, noteRepository);
  }
}