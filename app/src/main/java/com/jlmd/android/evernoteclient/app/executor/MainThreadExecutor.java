package com.jlmd.android.evernoteclient.app.executor;

/**
 * Interface for main thread executor
 *
 * @author jlmd
 */
public interface MainThreadExecutor {

  void execute(Runnable runnable);
}