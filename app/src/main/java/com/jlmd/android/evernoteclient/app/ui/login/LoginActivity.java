package com.jlmd.android.evernoteclient.app.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.evernote.client.android.EvernoteSession;
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

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
      case EvernoteSession.REQUEST_CODE_LOGIN:
        if (resultCode == Activity.RESULT_OK) {
          loginPresenter.onLoggedOk();
        } else {
          loginPresenter.onLoginFailure();
        }
        break;
      default:
        super.onActivityResult(requestCode, resultCode, data);
        break;
    }
  }
}
