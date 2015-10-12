package com.jlmd.android.evernoteclient.app.ui.noteslist.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.app.base.BaseActivity;
import com.jlmd.android.evernoteclient.app.ui.View;
import com.jlmd.android.evernoteclient.app.ui.custom.recyclerview.ClickRecyclerView;
import com.jlmd.android.evernoteclient.app.ui.noteslist.adapter.NotesListAdapter;
import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.presentation.Presenter;
import com.jlmd.android.evernoteclient.presentation.noteslist.NotesListPresenter;
import java.util.List;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class NotesListActivity extends BaseActivity implements View {

  @Inject protected NotesListPresenter notesListPresenter;
  @Bind(R.id.toolbar) protected Toolbar toolbar;
  @Bind(R.id.rv_notes_list) protected ClickRecyclerView notesRecyclerView;
  @Bind(R.id.pb_loading) protected ProgressBar pbLoading;
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
    notesRecyclerView.setHasFixedSize(false);
    notesListAdapter = new NotesListAdapter();
    notesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    notesRecyclerView.setAdapter(notesListAdapter);
    notesRecyclerView.setOnItemClickListener(new ClickRecyclerView.OnItemClickListener() {
      @Override
      public void onItemClick(RecyclerView parent, android.view.View view, int position, long id) {
        notesListPresenter.onItemClicked(position);
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_list_notes, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
      case R.id.menu_item_sort_note_title:
        notesListPresenter.sortNotesByTitle();
        return true;
      case R.id.menu_item_sort_note_date:
        notesListPresenter.sortNotesByDate();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public Presenter bindPresenter() {
    return notesListPresenter;
  }

  public void renderNotes(List<Note> notes) {
    notesListAdapter.updateNotes(notes);
  }

  public void showLoading() {
    pbLoading.setVisibility(android.view.View.VISIBLE);
  }

  public void hideLoading() {
    pbLoading.setVisibility(android.view.View.INVISIBLE);
  }

  public void showUnexpectedError() {
    Toast.makeText(getApplicationContext(),
        getResources().getString(R.string.list_notes_unexpected_error), Toast.LENGTH_LONG).show();
  }

  @OnClick(R.id.fab_add_note)
  public void onAddNoteClick() {
    notesListPresenter.onAddItemClick();
  }
}
