package com.jlmd.android.evernoteclient.app.di;

import android.content.Context;
import com.jlmd.android.evernoteclient.domain.repository.CredentialsRepository;
import com.jlmd.android.evernoteclient.domain.repository.CredentialsSharedPreferences;
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
  CredentialsRepository provideCredentialsRepository(Context appContext) {
    return new CredentialsSharedPreferences(appContext);
  }
}