package com.jlmd.android.evernoteclient.data.mapper;

import com.jlmd.android.evernoteclient.domain.model.Note;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jlmd
 */
public class NoteFromDomainMapperTest {

  @Test
  public void testSameTitle() {
    Note note = provideFakeNote();
    com.evernote.edam.type.Note mappedNote =
        new NoteFromDomainMapper().map(note);
    assertEquals("title", mappedNote.getTitle());
  }

  @Test
  public void testSameContent() {
    Note note = provideFakeNote();
    com.evernote.edam.type.Note mappedNote =
        new NoteFromDomainMapper().map(note);
    assertEquals("content", mappedNote.getContent());
  }

  @Test
  public void testSameAuthor() {
    Note note = provideFakeNote();
    com.evernote.edam.type.Note mappedNote =
        new NoteFromDomainMapper().map(note);
    assertEquals("author", mappedNote.getAttributes().getAuthor());
  }

  @Test
  public void testSameCreatedDate() {
    Note note = provideFakeNote();
    com.evernote.edam.type.Note mappedNote =
        new NoteFromDomainMapper().map(note);
    assertEquals(1, mappedNote.getCreated());
  }

  private Note provideFakeNote() {
    com.jlmd.android.evernoteclient.domain.model.Note note =
        new com.jlmd.android.evernoteclient.domain.model.Note("title", "author", "content");
    note.setCreated(1);
    return note;
  }
}
