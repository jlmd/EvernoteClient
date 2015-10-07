package com.jlmd.android.evernoteclient.app.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Executor which uses main thread looper
 *
 * @author jlmd
 */
public class MainThreadExecutorImp implements MainThreadExecutor {

  private Handler handler;

  public MainThreadExecutorImp() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  @Override
  public void execute(Runnable runnable) {
    handler.post(runnable);
  }
}