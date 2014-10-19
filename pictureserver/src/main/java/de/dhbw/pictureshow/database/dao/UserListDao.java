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
public class UserListDao extends JpaDao<UuidId, User> {
  public UserListDao() {
    super(User.class);
  }

  @SuppressWarnings("unchecked")
  public Collection<User> findByEmail(String email) {
    Query query = entityManager.createQuery("select u from User u where u.email = :email");
    query.setParameter("email", email);
    return (Collection<User>) query.getResultList();
  }

  public Collection<User> findByName(String name) {
    Query query = entityManager.createQuery("select u from User u where u.name = :name");
    query.setParameter("name", name);
    return (Collection<User>) query.getResultList();
  }
}

