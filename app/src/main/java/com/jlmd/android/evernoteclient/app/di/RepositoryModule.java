package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.data.datasource.NoteDataSource;
import com.jlmd.android.evernoteclient.data.mapper.NoteFromDomainMapper;
import com.jlmd.android.evernoteclient.data.mapper.NotesToDomainMapper;
import com.jlmd.android.evernoteclient.data.repository.NoteRepository;
import com.jlmd.android.evernoteclient.data.repository.NoteRepositoryImp;
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
  NoteRepository provideNotesListRepository(NoteDataSource noteDataSource,
      NotesToDomainMapper notesToDomainMapper, NoteFromDomainMapper noteFromDomainMapper) {
    return new NoteRepositoryImp(noteDataSource, notesToDomainMapper, noteFromDomainMapper);
  }
}