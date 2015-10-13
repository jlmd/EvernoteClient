package com.jlmd.android.evernoteclient.app.di;

import android.content.Context;
import com.evernote.client.android.EvernoteSession;
import com.jlmd.android.evernoteclient.domain.utils.Constants;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module which provides the Evernote SDK
 *
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class EvernoteSDKModule {

  @Provides
  @Singleton
  EvernoteSession.EvernoteService provideEvernoteService() {
    return EvernoteSession.EvernoteService.SANDBOX;
  }

  @Provides
  @Singleton
  EvernoteSession provideEvernoteSession(Context appContext,
      EvernoteSession.EvernoteService evernoteService) {
    return new EvernoteSession.Builder(appContext).setEvernoteService(evernoteService)
        .setSupportAppLinkedNotebooks(true)
        .build(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET)
        .asSingleton();
  }
}
