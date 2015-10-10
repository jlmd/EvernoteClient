package com.jlmd.android.evernoteclient.app.ui.noteslist.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jlmd.android.evernoteclient.R;
import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.ViewHolder> {

  private List<Note> notes = Collections.emptyList();

  @Override
  public NotesListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View modelView =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.note_view, viewGroup, false);
    return new ViewHolder(modelView);
  }

  @Override
  public int getItemCount() {
    return notes.size();
  }

  @Override
  public void onBindViewHolder(NotesListAdapter.ViewHolder viewHolder, int i) {
    Note note = notes.get(i);
    renderNoteView(note, viewHolder);
  }

  private void renderNoteView(Note note, ViewHolder viewHolder) {
    viewHolder.tvTitle.setText(note.getTitle());
    viewHolder.tvContent.setText(note.getContent());
  }

  public void updateNotes(List<Note> notes) {
    this.notes = notes;
    notifyDataSetChanged();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_title) protected TextView tvTitle;
    @Bind(R.id.tv_content) protected TextView tvContent;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
