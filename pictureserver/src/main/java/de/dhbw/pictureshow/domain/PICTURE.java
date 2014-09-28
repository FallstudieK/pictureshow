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

public class PICTURE extends PersistentObject{

    private String title;

    @Lob
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "uuid")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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


}
