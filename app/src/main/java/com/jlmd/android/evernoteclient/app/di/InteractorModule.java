package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.domain.interactor.login.Login;
import com.jlmd.android.evernoteclient.domain.repository.CredentialsRepository;
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
  Login provideLogin(InteractorExecutor interactorExecutor, MainThreadExecutor mainThreadExecutor,
      Navigator navigator, CredentialsRepository credentialsRepository) {
    return new Login(interactorExecutor, mainThreadExecutor, navigator, credentialsRepository);
  }
}