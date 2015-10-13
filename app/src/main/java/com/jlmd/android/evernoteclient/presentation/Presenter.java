package com.jlmd.android.evernoteclient.presentation;

import com.jlmd.android.evernoteclient.app.ui.View;

/**
 * Abstract presenter with activity lifecycle
 *
 * @param <T> View
 * @author jlmd
 */
public abstract class Presenter<T extends View> {

  protected T view;

  public void setView(T view) {
    this.view = view;
  }

  public void onCreate() {
    // Empty
  }

  public void onResume() {
    // Empty
  }

  public void onPause() {
    // Empty
  }

  public void onDestroy() {
    // Empty
  }
}