package com.jlmd.android.evernoteclient.domain.repository;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.jlmd.android.evernoteclient.domain.model.Credentials;

/**
 * @author jlmd
 */
public class CredentialsSharedPreferences implements CredentialsRepository {

  private static final String SHARED_PREFERENCES = "SHARED_PREFS";
  private static final String CREDENTIALS_KEY = "CREDENTIALS_KEY";
  private final SharedPreferences sharedPreferences;
  private final Gson gson;

  public CredentialsSharedPreferences(Context context) {
    this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    this.gson = new Gson();
  }

  @Override
  public Credentials getCredentials() {
    return gson.fromJson(sharedPreferences.getString(CREDENTIALS_KEY, null), Credentials.class);
  }

  @Override
  public void setCredentials(Credentials credentials) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(CREDENTIALS_KEY, gson.toJson(credentials));
    editor.commit();
  }
}
