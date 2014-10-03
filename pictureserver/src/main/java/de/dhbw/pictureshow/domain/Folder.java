package de.dhbw.pictureshow.domain;
import javax.persistence.Entity;
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
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "User{" +
                "folderid='" + id + '\'' +
                ", fname='" + fname + '\'' +
                "date='" + fdate + '\'' +
                "userId='" + userId + '\'' +
                '}';
    }
}