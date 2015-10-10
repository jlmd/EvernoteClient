package com.jlmd.android.evernoteclient.data.repository;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.List;

/**
 * @author jlmd
 */
public interface NotesListRepository {

  List<Note> getNotes();
}
