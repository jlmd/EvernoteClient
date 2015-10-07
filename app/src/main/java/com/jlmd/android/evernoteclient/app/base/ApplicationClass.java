package com.jlmd.android.evernoteclient.app.base;

import android.app.Application;
import com.jlmd.android.evernoteclient.app.di.RootModule;
import dagger.ObjectGraph;

/**
 * @author jlmd
 */
public class ApplicationClass extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(new RootModule(this));
    objectGraph.inject(this);
  }

  public void inject(Object className) {
    objectGraph.inject(className);
  }
}