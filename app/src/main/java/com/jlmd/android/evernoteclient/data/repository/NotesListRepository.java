package com.jlmd.android.evernoteclient.data.repository;

import com.evernote.edam.type.Note;
import java.util.List;

/**
 * @author jlmd
 */
public interface NotesListRepository {

  List<Note> getNotes();
}
