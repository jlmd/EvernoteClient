package com.jlmd.android.evernoteclient.domain.model;

/**
 * @author jlmd
 */
public class Note {

  private String title;
  private String content;
  private long created;
  private String notebookGuid;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public String getNotebookGuid() {
    return notebookGuid;
  }

  public void setNotebookGuid(String notebookGuid) {
    this.notebookGuid = notebookGuid;
  }
}
