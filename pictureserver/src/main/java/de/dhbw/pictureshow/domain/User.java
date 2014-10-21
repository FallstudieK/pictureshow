package de.dhbw.pictureshow.domain;


import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class User extends PersistentObject {
  private String name;
  private String email;
  private String vorname;
  private String password;


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
