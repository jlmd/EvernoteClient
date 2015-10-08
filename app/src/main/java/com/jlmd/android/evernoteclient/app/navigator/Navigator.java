package com.jlmd.android.evernoteclient.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * @author jlmd
 */
public class Navigator {

  private Activity activity;

  public Activity getActivity() {
    return activity;
  }

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  public void openWebsite(String url) {
    Uri uri = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    activity.startActivity(intent);
  }
}
