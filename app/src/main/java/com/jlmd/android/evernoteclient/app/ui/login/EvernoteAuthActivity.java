package com.jlmd.android.evernoteclient.app.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.jlmd.android.evernoteclient.app.base.ApplicationClass;
import com.jlmd.android.evernoteclient.domain.interactor.login.Login;
import javax.inject.Inject;

/**
 * @author joseluis
 */
public class EvernoteAuthActivity extends Activity {

  @Inject protected Login login;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();

    Intent intent = getIntent();
    if (Intent.ACTION_VIEW.equals(intent.getAction())) {
      Uri uri = intent.getData();
      String oauthVerifier = uri.getQueryParameter("oauth_verifier");
      login.obtainAccessToken(oauthVerifier);
      finish();
    }
  }

  private void injectDependencies() {
    ((ApplicationClass) getApplication()).inject(this);
  }
}
