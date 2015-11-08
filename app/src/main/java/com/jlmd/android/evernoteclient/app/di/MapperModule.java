package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.data.mapper.NoteFromDomainMapper;
import com.jlmd.android.evernoteclient.data.mapper.NotesToDomainMapper;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module which provides mappers
 *
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class MapperModule {

  @Provides
  NoteFromDomainMapper provideNoteFromDomainMapper() {
    return new NoteFromDomainMapper();
  }

  @Provides
  NotesToDomainMapper provideNotesToDomainMapper() {
    return new NotesToDomainMapper();
  }
}