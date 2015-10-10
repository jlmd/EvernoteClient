package com.jlmd.android.evernoteclient.app.ui.notedetails;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.notedetails.NoteDetailsPresenter;
import java.util.Date;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class NoteDetailsActivity extends BaseActivity implements View {

  public static final String NOTE_KEY = "NOTE_KEY";
  @Inject protected NoteDetailsPresenter noteDetailsPresenter;
  @Bind(R.id.tv_title) protected TextView tvTitle;
  @Bind(R.id.tv_content) protected TextView tvContent;
  @Bind(R.id.tv_created_date) protected TextView tvCreatedDate;
  @Bind(R.id.tv_author) protected TextView tvAuthor;
  @Bind(R.id.toolbar) protected Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.note_details_view);
    ButterKnife.bind(this);
    initToolbar();
    noteDetailsPresenter.onNoteReceived(getNoteFromExtras());
  }

  private void initToolbar() {
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {
      @Override
      public void onClick(android.view.View v) {
        noteDetailsPresenter.onBackPressed();
      }
    });
  }

  private Note getNoteFromExtras() {
    return getIntent().getExtras().getParcelable(NOTE_KEY);
  }

  @Override
  public Presenter bindPresenter() {
    return noteDetailsPresenter;
  }

  public void renderNote(Note note) {
    tvTitle.setText(note.getTitle());
    tvContent.setText(note.getContent());
    tvCreatedDate.setText(new Date(note.getCreated()) + "");
    tvAuthor.setText(note.getAuthor());
  }
}
