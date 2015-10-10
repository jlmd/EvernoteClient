package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.data.mapper.NotesMapper;
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
  NotesMapper provideNotesMapper() {
    return new NotesMapper();
  }
}