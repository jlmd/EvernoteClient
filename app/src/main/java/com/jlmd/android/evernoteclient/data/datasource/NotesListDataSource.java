package com.jlmd.android.evernoteclient.data.datasource;

import com.evernote.edam.type.Note;
import java.util.List;

/**
 * @author jlmd
 */
public interface NotesListDataSource {

  List<Note> getNotes();
}
