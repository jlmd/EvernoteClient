package com.jlmd.android.evernoteclient.app.di;

import android.content.Context;
import com.jlmd.android.evernoteclient.app.base.ApplicationClass;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.login.EvernoteAuthActivity;
import com.jlmd.android.evernoteclient.app.ui.login.LoginActivity;
import com.jlmd.android.evernoteclient.app.ui.main.MainActivity;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */

@Module(
    includes = {
        PresenterModule.class, InteractorModule.class, ExecutorModule.class, RepositoryModule.class
    },
    injects = {
        ApplicationClass.class, LoginActivity.class, EvernoteAuthActivity.class, MainActivity.class
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

  @Provides
  @Singleton
  public Navigator provideNavigator() {
    return new Navigator();
  }
}