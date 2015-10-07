package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.presentation.login.LoginPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class PresenterModule {

  @Provides
  @Singleton
  LoginPresenter provideLoginPresenter() {
    return new LoginPresenter();
  }
}