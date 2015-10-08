package com.jlmd.android.evernoteclient.app.di;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutorImp;
import com.jlmd.android.evernoteclient.app.executor.ThreadExecutor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class ExecutorModule {

  @Provides
  @Singleton
  InteractorExecutor providesInteractroExecutor() {
    return new ThreadExecutor();
  }

  @Provides
  @Singleton
  MainThreadExecutor providesMainThreadExecutor() {
    return new MainThreadExecutorImp();
  }
}