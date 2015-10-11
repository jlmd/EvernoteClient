package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.data.mapper.NoteFromDomainMapper;
import com.jlmd.android.evernoteclient.data.mapper.NotesToDomainMapper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class MapperModule {

  @Provides
  @Singleton
  NoteFromDomainMapper provideNoteFromDomainMapper() {
    return new NoteFromDomainMapper();
  }

  @Provides
  @Singleton
  NotesToDomainMapper provideNotesToDomainMapper() {
    return new NotesToDomainMapper();
  }
}