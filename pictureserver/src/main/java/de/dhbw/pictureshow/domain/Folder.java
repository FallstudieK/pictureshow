package de.dhbw.pictureshow.domain;

/**
 * Created by koeppent on 19.10.2014.
 */

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class Folder extends PersistentObject {

  private String fname;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Override
  public String toString() {
    return "Folder{" +
        "id='" + id + '\'' +
        ", name='" + fname + '\'' +
        '}';
  }
}
