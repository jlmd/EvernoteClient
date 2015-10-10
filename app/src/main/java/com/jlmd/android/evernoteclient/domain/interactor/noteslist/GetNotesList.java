package com.jlmd.android.evernoteclient.domain.interactor.noteslist;

import com.jlmd.android.evernoteclient.app.executor.InteractorExecutor;
import com.jlmd.android.evernoteclient.app.executor.MainThreadExecutor;
import com.jlmd.android.evernoteclient.domain.interactor.AbstractInteractor;

/**
 * @author jlmd
 */
public class GetNotesList extends AbstractInteractor {

  public GetNotesList(InteractorExecutor interactorExecutor,
      MainThreadExecutor mainThreadExecutor) {
    super(interactorExecutor, mainThreadExecutor);
  }

  @Override
  public void run() {

  }
}
