package com.jlmd.android.evernoteclient.app.ui.login;

import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    ButterKnife.bind(this);
  }

  @Override
  public Presenter bindPresenter() {
    return loginPresenter;
  }

  public void showError() {
    Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_error),
        Toast.LENGTH_SHORT).show();
  }

  @OnClick(R.id.btn_login)
  public void onLoginButtonPressed() {
    loginPresenter.onLoginButtonPressed();
  }
}
