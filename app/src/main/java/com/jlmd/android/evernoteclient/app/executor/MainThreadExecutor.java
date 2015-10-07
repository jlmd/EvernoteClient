package com.jlmd.android.evernoteclient.app.executor;

/**
 * @author jlmd
 */
public interface MainThreadExecutor {

  void execute(Runnable runnable);
}