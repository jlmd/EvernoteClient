package com.jlmd.android.evernoteclient.domain.comparator;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jlmd
 */
public class NoteTitleComparatorTest {

  @Test
  public void testNotesAreSortedByTitle() {
    List<Note> notes = new ArrayList<>();
    Note note1 = new Note();
    note1.setTitle("ccc");
    notes.add(note1);
    Note note2 = new Note();
    note2.setTitle("bbb");
    notes.add(note2);
    Note note3 = new Note();
    note3.setTitle("aaa");
    notes.add(note3);

    Collections.sort(notes, new NoteTitleComparator());
    assertEquals("aaa", notes.get(0).getTitle());
  }
}
