package com.jlmd.android.evernoteclient.app.ui.addnote;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.app.ui.custom.drawpanel.DrawPanelDialog;
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
  @Bind(R.id.pb_loading) protected ProgressBar pbLoading;

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

  public void showUnexpectedError() {
    Toast.makeText(getApplicationContext(),
        getResources().getString(R.string.add_note_unexpected_error), Toast.LENGTH_LONG).show();
  }

  public void showLoading() {
    pbLoading.setVisibility(android.view.View.VISIBLE);
  }

  public void hideLoading() {
    pbLoading.setVisibility(android.view.View.INVISIBLE);
  }

  public void setTextOnFocusedElement(String text) {
    if (getCurrentFocus() instanceof EditText) {
      ((EditText) getCurrentFocus()).setText(text);
    }
  }

  public void showDrawPanel() {
    new DrawPanelDialog(this, new DrawPanelDialog.Callback() {
      @Override
      public void onBitmapCreated(final Bitmap bitmap) {
        addNotePresenter.onBitmapCreated(bitmap);
      }
    }).show();
  }

  @Override
  public Presenter bindPresenter() {
    return addNotePresenter;
  }

  @OnClick(R.id.ic_draw_note)
  public void onDrawNoteClick() {
    addNotePresenter.onDrawTextClick();
  }

  @OnClick(R.id.iv_save_note)
  public void onSaveNoteClick() {
    addNotePresenter.onSaveNoteClick(etTitle.getText().toString(), etAuthor.getText().toString(),
        etContent.getText().toString());
  }
}
