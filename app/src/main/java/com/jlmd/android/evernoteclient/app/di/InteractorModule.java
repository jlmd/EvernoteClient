package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.data.repository.NotesListRepository;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class InteractorModule {

  @Provides
  @Singleton
  GetNotesList provideGetNotesList(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor, NotesListRepository notesListRepository) {
    return new GetNotesList(interactorExecutor, mainThreadExecutor, notesListRepository);
  }
}