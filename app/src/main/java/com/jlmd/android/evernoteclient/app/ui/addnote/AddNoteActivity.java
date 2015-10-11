package com.jlmd.android.evernoteclient.app.ui.addnote;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
  @Bind(R.id.toolbar) protected Toolbar toolbar;
  @Bind(R.id.et_title) protected EditText etTitle;
  @Bind(R.id.et_author) protected EditText etAuthor;
  @Bind(R.id.et_content) protected EditText etContent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add_note_view);
    ButterKnife.bind(this);
    initToolbar();
  }

  private void initToolbar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    getSupportActionBar().setTitle(getResources().getString(R.string.add_note_toolbar));
    toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
      @Override
      public void onClick(android.view.View v) {
        addNotePresenter.onBackPressed();
      }
    });
  }

  @Override
  public Presenter bindPresenter() {
    return addNotePresenter;
  }

  @OnClick(R.id.iv_save_note)
  public void onSaveNoteClick() {
    addNotePresenter.saveNote(etTitle.getText().toString(), etAuthor.getText().toString(),
        etContent.getText().toString());
  }
}
