package com.jlmd.android.evernoteclient.app.base;

import android.app.Activity;
import android.os.Bundle;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public abstract class BaseActivity extends Activity implements View {

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
