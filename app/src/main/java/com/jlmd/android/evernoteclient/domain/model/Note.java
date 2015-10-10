package com.jlmd.android.evernoteclient.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author jlmd
 */
public class Note implements Parcelable {

  @SuppressWarnings("unused") public static final Parcelable.Creator<Note> CREATOR =
      new Parcelable.Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
          return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
          return new Note[size];
        }
      };
  private String title;
  private String content;
  private long created;
  private String author;

  public Note() {
    // Empty constructor
  }

  protected Note(Parcel in) {
    title = in.readString();
    content = in.readString();
    created = in.readLong();
    author = in.readString();
  }

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeString(content);
    dest.writeLong(created);
    dest.writeString(author);
  }
}