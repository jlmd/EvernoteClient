package com.jlmd.android.evernoteclient.app.ui.login;

import android.os.Bundle;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.login.LoginPresenter;
import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements View {

  @Inject protected LoginPresenter loginPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_view);
  }

  @Override
  public Presenter bindPresenter() {
    return loginPresenter;
  }

  public void showLoading() {

  }

  public void hideLoading() {

  }

  public void showError(String errorMessage) {

  }
}
