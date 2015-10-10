package com.jlmd.android.evernoteclient.data.datasource;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.asyncclient.EvernoteNoteStoreClient;
import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.type.Note;
import com.evernote.thrift.TException;
import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class NotesListSDKDataSource implements NotesListDataSource {

  private final EvernoteSession evernoteSession;

  public NotesListSDKDataSource(EvernoteSession evernoteSession) {
    this.evernoteSession = evernoteSession;
  }

  @Override
  public List<Note> getNotes() {
    EvernoteNoteStoreClient noteStoreClient =
        evernoteSession.getEvernoteClientFactory().getNoteStoreClient();
    try {
      return noteStoreClient.findNotes(new NoteFilter(), 0, 100).getNotes();
    } catch (EDAMUserException e) {
      e.printStackTrace();
    } catch (EDAMSystemException e) {
      e.printStackTrace();
    } catch (EDAMNotFoundException e) {
      e.printStackTrace();
    } catch (TException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }
}
