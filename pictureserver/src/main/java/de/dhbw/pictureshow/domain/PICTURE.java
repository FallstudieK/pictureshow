package de.dhbw.pictureshow.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by koeppent on 23.09.2014.
 */

@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling

public class PICTURE extends PersistentObject {

  private String title;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String username;
  private String file;
  @Lob
  private byte[] picture;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private USERS user;
  @ManyToOne
  @JoinColumn(name = "folder_id")
  private Folder folder;

  public Folder getFolder() {
    return folder;
  }

  public void setFolder(Folder folder) {
    this.folder = folder;
  }

  public USERS getUser() {
    return user;
  }

  public void setUser(USERS user) {
    this.user = user;
  }


  public String getTitle() {
    return title;
  }

  public byte[] getPicture() {
    return picture;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setPicture(byte[] picture) {
    this.picture = picture;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }


  @Override
  public String toString() {
    return "Picture  " +
        title;
  }
}
