package com.jlmd.android.evernoteclient.data.repository;

import com.jlmd.android.evernoteclient.data.datasource.NotesListDataSource;
import com.jlmd.android.evernoteclient.data.mapper.NotesMapper;
import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListRepositoryImp implements NotesListRepository {

  private final NotesListDataSource notesListDataSource;
  private final NotesMapper notesMapper;

  public NotesListRepositoryImp(NotesListDataSource notesListDataSource, NotesMapper notesMapper) {
    this.notesListDataSource = notesListDataSource;
    this.notesMapper = notesMapper;
  }

  @Override
  public List<Note> getNotes() {
    return notesMapper.map(notesListDataSource.getNotes());
  }
}
