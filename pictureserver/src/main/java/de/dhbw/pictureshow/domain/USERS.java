package de.dhbw.pictureshow.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by koeppent on 25.09.2014.
 */

@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class USERS extends PersistentObject{

        private String name;
        private String password;
        private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return id + " ; " + email + " ; " + password;
        }
    }
