package com.jlmd.android.evernoteclient.app.ui.noteslist;

import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.noteslist.NotesListPresenter;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class NotesListActivity extends BaseActivity {

  @Inject protected NotesListPresenter notesListPresenter;

  @Override
  public Presenter bindPresenter() {
    return notesListPresenter;
  }
}
