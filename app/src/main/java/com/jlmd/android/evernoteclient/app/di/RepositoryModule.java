package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.data.datasource.NotesListDataSource;
import com.jlmd.android.evernoteclient.data.mapper.NotesMapper;
import com.jlmd.android.evernoteclient.data.repository.NotesListRepository;
import com.jlmd.android.evernoteclient.data.repository.NotesListRepositoryImp;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class RepositoryModule {

  @Provides
  @Singleton
  NotesListRepository provideNotesListRepository(NotesListDataSource notesListDataSource,
      NotesMapper notesMapper) {
    return new NotesListRepositoryImp(notesListDataSource, notesMapper);
  }
}