package com.jlmd.android.evernoteclient.domain.comparator;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.Comparator;
import java.util.Date;

/**
 * Comparator for sort notes by date
 *
 * @author jlmd
 */
public class NoteDateComparator implements Comparator<Note> {

  @Override
  public int compare(Note lhs, Note rhs) {
    return new Date(lhs.getCreated()).compareTo(new Date(rhs.getCreated()));
  }
}
