package com.jlmd.android.evernoteclient.app.di;

import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.data.datasource.NoteDataSource;
import com.jlmd.android.evernoteclient.data.datasource.NoteSDKDataSource;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for data sources
 *
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class DataSourceModule {

  @Provides
  NoteDataSource provideNotesListDataSource(EvernoteSession evernoteSession) {
    return new NoteSDKDataSource(evernoteSession);
  }
}
