package com.jlmd.android.evernoteclient.app.ui.main;

import android.os.Bundle;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.main.MainPresenter;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class MainActivity extends BaseActivity {

  @Inject protected MainPresenter mainPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_view);
  }

  @Override
  public Presenter bindPresenter() {
    return mainPresenter;
  }
}
