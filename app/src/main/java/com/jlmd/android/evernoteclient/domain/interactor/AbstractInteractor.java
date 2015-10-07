package com.jlmd.android.evernoteclient.domain.interactor;

import com.jlmd.android.evernoteclient.app.executor.Interactor;
import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;

/**
 * @author jlmd
 */
public abstract class AbstractInteractor implements Interactor {

  private InteractorExecutor interactorExecutor;
  private MainThreadExecutor mainThreadExecutor;

  public AbstractInteractor(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor) {
    this.interactorExecutor = interactorExecutor;
    this.mainThreadExecutor = mainThreadExecutor;
  }

  public void executeCurrentInteractor() {
    interactorExecutor.run(this);
  }

  public void executeInMainThread(Runnable runnable) {
    mainThreadExecutor.execute(runnable);
  }
}