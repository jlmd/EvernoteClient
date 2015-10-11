package com.jlmd.android.evernoteclient.domain.parser;

/**
 * Parser for note content which adds DNML structure to a provided text
 *
 * @author jlmd
 */
public final class NoteContentParser {

  private static final String CONTENT_TEXT_MASK =
      "<!DOCTYPE en-note SYSTEM 'http://xml.evernote.com/pub/enml2.dtd'><en-note>%s</en-note>";

  private NoteContentParser() {
    // Empty
  }

  /**
   * Adds DNML structure to a text
   * @param text Text to add
   * @return Formatted DNML content with provided text
   */
  public static String getContentText(String text) {
    return String.format(CONTENT_TEXT_MASK, text);
  }
}
