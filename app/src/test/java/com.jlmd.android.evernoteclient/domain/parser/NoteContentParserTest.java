package com.jlmd.android.evernoteclient.domain.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jlmd
 */
public class NoteContentParserTest {

  @Test
  public void testGetTextFromContent() {
    String content =
        "<!DOCTYPE en-note SYSTEM 'http://xml.evernote.com/pub/enml2.dtd'><en-note>text</en-note>";
    assertEquals("text", NoteContentParser.getTextFromContent(content));
  }

  @Test
  public void testGetContentText() {
    String text = "text";
    String expected =
        "<!DOCTYPE en-note SYSTEM 'http://xml.evernote.com/pub/enml2.dtd'><en-note>text</en-note>";
    assertEquals(expected, NoteContentParser.getContentText(text));
  }
}
