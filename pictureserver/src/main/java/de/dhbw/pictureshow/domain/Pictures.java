package de.dhbw.pictureshow.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by koeppent on 20.10.2014.
 */

@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling

public class Pictures extends PersistentObject {

  private String title;
  private String beschreibung;
  private String file;
  private String username;

  public String getFoldername() {
    return foldername;
  }

  public void setFoldername(String foldername) {
    this.foldername = foldername;
  }

  private String foldername;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBeschreibung() {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) {
    this.beschreibung = beschreibung;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Folder getFolder() {
    return folder;
  }

  public void setFolder(Folder folder) {
    this.folder = folder;
  }

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  @ManyToOne
  @JoinColumn(name = "folder_id")
  private Folder folder;


  @Override
  public String toString() {
    return "User{" +
        "id='" + file + '\'' +
        ", name='" + title + '\'' +
        '}';

  }
}
