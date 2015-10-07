package com.jlmd.android.evernoteclient.app.di;

import android.content.Context;
import com.jlmd.android.evernoteclient.app.base.ApplicationClass;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */

@Module(
    includes = {
        PresenterModule.class
    },
    injects = {
        ApplicationClass.class, LoginActivity.class
    },
    library = true)
public final class RootModule {

  private final Context context;

  public RootModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  public Context provideApplicationContext() {
    return context;
  }
}