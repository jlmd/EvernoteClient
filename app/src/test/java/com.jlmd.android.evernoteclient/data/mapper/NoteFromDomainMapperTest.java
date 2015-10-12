package com.jlmd.android.evernoteclient.data.mapper;

import com.evernote.edam.type.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jlmd
 */
public class NoteFromDomainMapperTest {

  private Note mappedNote;

  @Before
  public void setUp() throws Exception {
    com.jlmd.android.evernoteclient.domain.model.Note note =
        new com.jlmd.android.evernoteclient.domain.model.Note("title", "author", "content");
    note.setCreated(1);

    mappedNote = new NoteFromDomainMapper().map(note);
  }

  @Test
  public void testSameTitle() {
    assertEquals("title", mappedNote.getTitle());
  }

  @Test
  public void testSameContent() {
    assertEquals("content", mappedNote.getContent());
  }

  @Test
  public void testSameAuthor() {
    assertEquals("author", mappedNote.getAttributes().getAuthor());
  }

  @Test
  public void testSameCreatedDate() {
    assertEquals(1, mappedNote.getCreated());
  }
}
