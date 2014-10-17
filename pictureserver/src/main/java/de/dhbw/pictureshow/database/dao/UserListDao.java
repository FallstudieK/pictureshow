package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.USERS;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by koeppent on 25.09.2014.
 */

@ApplicationScoped
public class UserListDao extends JpaDao<UuidId,USERS> {
        public UserListDao() {
            super(USERS.class);
        }
        @SuppressWarnings("unchecked")
        public Collection<USERS> findByEmail(String email) {
            Query query = entityManager.createQuery("select u from Users u where u.email = :email");
            query.setParameter("email", email);
            return (Collection<USERS>)query.getResultList();
        }
    public Collection<USERS> findByName(String name) {
        Query query = entityManager.createQuery("select u from USERS u where u.name = :name");
        query.setParameter("name", name);
        return (Collection<USERS>)query.getResultList();
    }
    }

