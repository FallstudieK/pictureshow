package de.dhbw.pictureshow.domain;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 */
@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class Folder extends PersistentObject {
    private String fname;
    private Date fdate;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private USERS user;


    public USERS getUser() {
        return user;
    }

    public void setUser(USERS user) {
        this.user = user;
    }

      public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "folderid='" + id + '\'' +
                ", fname='" + fname + '\'' +
                "date='" + fdate + '\'' +
                "userId='" + user + '\'' +
                '}';
    }
}