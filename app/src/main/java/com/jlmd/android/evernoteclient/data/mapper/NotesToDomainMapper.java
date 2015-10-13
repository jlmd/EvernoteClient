package com.jlmd.android.evernoteclient.data.mapper;

import com.jlmd.android.evernoteclient.domain.model.Note;
import com.jlmd.android.evernoteclient.domain.parser.NoteContentParser;
import java.util.ArrayList;
import java.util.List;

/**
 * Maps a list of sdk note to domain note
 *
 * @author jlmd
 */
public class NotesToDomainMapper
    implements Mapper<List<com.evernote.edam.type.Note>, List<Note>> {

  private Note mapNote(com.evernote.edam.type.Note note) {
    Note mappedNote = new Note();
    mappedNote.setTitle(note.getTitle());
    mappedNote.setContent(NoteContentParser.getTextFromContent(note.getContent()));
    mappedNote.setCreated(note.getCreated());
    mappedNote.setAuthor(note.getAttributes().getAuthor());
    return mappedNote;
  }

  @Override
  public List<Note> map(List<com.evernote.edam.type.Note> notes) {
    List<Note> mappedNotes = new ArrayList<>();
    for (com.evernote.edam.type.Note note : notes) {
      mappedNotes.add(mapNote(note));
    }
    return mappedNotes;
  }
}
