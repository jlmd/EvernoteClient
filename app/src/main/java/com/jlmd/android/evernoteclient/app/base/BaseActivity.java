package com.jlmd.android.evernoteclient.app.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import javax.inject.Inject;

/**
 * Activity used as base in every activities.
 * Binds activity lifecycle with presenter, injects dagger, and defines current activity in
 * navigator
 *
 * @author jlmd
 */
public abstract class BaseActivity extends AppCompatActivity implements View {

  @Inject protected Navigator navigator;
  private Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    onBeforeCreate();
    super.onCreate(savedInstanceState);
    injectDependencies();
    navigator.setActivity(this);
    presenter = bindPresenter();
    presenter.onCreate();
    presenter.setView(this);
  }

  private void injectDependencies() {
    ((ApplicationClass) getApplication()).inject(this);
  }

  @Override
  protected void onPause() {
    super.onPause();
    presenter.onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  protected void onBeforeCreate() {
    // Empty
  }

  public abstract Presenter bindPresenter();
}
