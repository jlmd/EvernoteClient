package com.jlmd.android.evernoteclient.domain.comparator;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author jlmd
 */
public class NoteDateComparatorTest {

  @Test
  public void testNotesAreSortedByDate() {
    List<Note> notes = new ArrayList<>();
    Note note1 = new Note();
    note1.setTitle("first");
    note1.setCreated(new Date().getTime() + 2);
    notes.add(note1);
    Note note2 = new Note();
    note2.setTitle("second");
    note2.setCreated(new Date().getTime() + 1);
    notes.add(note2);
    Note note3 = new Note();
    note3.setTitle("third");
    note3.setCreated(new Date().getTime());
    notes.add(note3);

    Collections.sort(notes, new NoteDateComparator());
    assertEquals("third", notes.get(0).getTitle());
  }
}
