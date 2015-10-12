package com.jlmd.android.evernoteclient.domain.comparator;

import com.jlmd.android.evernoteclient.domain.model.Note;
import java.util.Comparator;

/**
 * @author jlmd
 */
public class NoteTitleComparator implements Comparator<Note> {

  @Override
  public int compare(Note lhs, Note rhs) {
    return lhs.getTitle().compareTo(rhs.getTitle());
  }
}