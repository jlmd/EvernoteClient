package com.jlmd.android.evernoteclient.app.ui.noteslist.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.custom.view.ClickRecyclerView;
import com.jlmd.android.evernoteclient.app.ui.noteslist.adapter.NotesListAdapter;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.noteslist.NotesListPresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class NotesListActivity extends BaseActivity {

  @Inject protected NotesListPresenter notesListPresenter;
  @Bind(R.id.toolbar) protected Toolbar toolbar;
  @Bind(R.id.rv_notes_list) protected ClickRecyclerView notesRecyclerView;
  private NotesListAdapter notesListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.notes_list_view);
    ButterKnife.bind(this);
    initRecyclerView();
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(true);
  }

  private void initRecyclerView() {
    //notesRecyclerView.setHasFixedSize(false);
    notesListAdapter = new NotesListAdapter();
    notesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    notesRecyclerView.setAdapter(notesListAdapter);
  }

  @Override
  public Presenter bindPresenter() {
    return notesListPresenter;
  }

  public void renderNotes(List<Note> notes) {
    notesListAdapter.updateNotes(notes);
  }
}
