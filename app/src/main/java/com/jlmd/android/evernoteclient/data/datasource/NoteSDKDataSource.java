package com.jlmd.android.evernoteclient.data.datasource;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.asyncclient.EvernoteNoteStoreClient;
import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.type.Note;
import com.evernote.thrift.TException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jlmd
 */
public class NoteSDKDataSource implements NoteDataSource {

  private final EvernoteSession evernoteSession;


  public NoteSDKDataSource(EvernoteSession evernoteSession) {
    this.evernoteSession = evernoteSession;
  }

  @Override
  public List<Note> getNotes() throws RuntimeException {
    EvernoteNoteStoreClient noteStoreClient =
        evernoteSession.getEvernoteClientFactory().getNoteStoreClient();
    try {
      List<Note> notes = noteStoreClient.findNotes(new NoteFilter(), 0, 1000).getNotes();
      List<Note> notesWithContent = new ArrayList<>();
      for (Note note : notes) {
        notesWithContent.add(noteStoreClient.getNote(note.getGuid(), true, false, false, false));
      }
      return notesWithContent;
    } catch (EDAMUserException | EDAMSystemException | EDAMNotFoundException | TException e) {
      throw new RuntimeException("Unexpected error obtaining notes using Evernote SDK", e);
    }
  }

  @Override
  public void addNote(Note note) throws RuntimeException {
    EvernoteNoteStoreClient noteStoreClient =
        evernoteSession.getEvernoteClientFactory().getNoteStoreClient();
    try {
      noteStoreClient.createNote(note);
    } catch (EDAMUserException | EDAMSystemException | TException | EDAMNotFoundException e) {
      throw new RuntimeException("Unexpected error adding note using Evernote SDK", e);
    }
  }
}
