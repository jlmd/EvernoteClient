package com.jlmd.android.evernoteclient.data.datasource;

import com.evernote.edam.type.Note;
import java.util.List;

/**
 * Interface used to abstract get note implementations
 *
 * @author jlmd
 */
public interface NoteDataSource {

  List<Note> getNotes();

  void addNote(Note note);
}
