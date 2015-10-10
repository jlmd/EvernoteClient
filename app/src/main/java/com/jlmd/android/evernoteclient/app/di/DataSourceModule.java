package com.jlmd.android.evernoteclient.app.di;

import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.data.datasource.NotesListDataSource;
import com.jlmd.android.evernoteclient.data.datasource.NotesListSDKDataSource;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class DataSourceModule {

  @Provides
  @Singleton
  NotesListDataSource provideNotesListDataSource(EvernoteSession evernoteSession) {
    return new NotesListSDKDataSource(evernoteSession);
  }
}
