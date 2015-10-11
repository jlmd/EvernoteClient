package com.jlmd.android.evernoteclient.data.repository;

import com.jlmd.android.evernoteclient.data.datasource.NoteDataSource;
import com.jlmd.android.evernoteclient.data.mapper.NoteFromDomainMapper;
import com.jlmd.android.evernoteclient.data.mapper.NotesToDomainMapper;
import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.List;

/**
 * @author jlmd
 */
public class NoteRepositoryImp implements NoteRepository {

  private final NoteDataSource noteDataSource;
  private final NotesToDomainMapper notesToDomainMapper;
  private final NoteFromDomainMapper noteMapper;

  public NoteRepositoryImp(NoteDataSource noteDataSource, NotesToDomainMapper notesToDomainMapper,
      NoteFromDomainMapper noteMapper) {
    this.noteDataSource = noteDataSource;
    this.notesToDomainMapper = notesToDomainMapper;
    this.noteMapper = noteMapper;
  }

  @Override
  public List<Note> getNotes() {
    return notesToDomainMapper.map(noteDataSource.getNotes());
  }

  @Override
  public void addNote(Note note) {
    noteDataSource.addNote(noteMapper.map(note));
  }
}
