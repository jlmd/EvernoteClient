package com.jlmd.android.evernoteclient.app.ui.addnote;

import android.os.Bundle;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.addnote.AddNotePresenter;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class AddNoteActivity extends BaseActivity implements View {

  @Inject protected AddNotePresenter addNotePresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_note_view);
  }

  @Override
  public Presenter bindPresenter() {
    return addNotePresenter;
  }
}
