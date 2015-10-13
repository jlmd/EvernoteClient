package com.jlmd.android.evernoteclient.data.repository;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.List;

/**
 * Repository used for abstract how notes are obtained
 *
 * @author jlmd
 */
public interface NoteRepository {

  List<Note> getNotes();

  void addNote(Note note);
}
