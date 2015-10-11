package com.jlmd.android.evernoteclient.data.mapper;

import com.evernote.edam.type.Note;
import com.evernote.edam.type.NoteAttributes;

/**
 * @author jlmd
 */
public class NoteFromDomainMapper
    implements Mapper<com.jlmd.android.evernoteclient.domain.model.Note, Note> {

  @Override
  public Note map(com.jlmd.android.evernoteclient.domain.model.Note note) {
    Note mappedNote = new Note();
    mappedNote.setTitle(note.getTitle());
    mappedNote.setContent(note.getContent());
    mappedNote.setCreated(note.getCreated());
    //NoteAttributes noteAttributes = new NoteAttributes();
    //noteAttributes.setAuthor(note.getAuthor());
    //mappedNote.setAttributes(noteAttributes);
    return mappedNote;
  }
}
