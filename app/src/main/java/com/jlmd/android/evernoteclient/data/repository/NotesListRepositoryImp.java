package com.jlmd.android.evernoteclient.data.repository;

import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.jlmd.android.evernoteclient.data.datasource.NotesListDataSource;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListRepositoryImp implements NotesListRepository {

  private final NotesListDataSource notesListDataSource;

  public NotesListRepositoryImp(NotesListDataSource notesListDataSource) {
    this.notesListDataSource = notesListDataSource;
  }

  @Override
  public List<Note> getNotes() {
    return notesListDataSource.getNotes();
  }
}
