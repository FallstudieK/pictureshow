package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Created by koeppent on 19.10.2014.
 */
@ApplicationScoped
public class FolderDao extends JpaDao<UuidId, Folder> {
  public FolderDao() {
    super(Folder.class);
  }

  @SuppressWarnings("unchecked")
  public Collection<Folder> findByName(String fname) {
    Query query = entityManager.createQuery("select f from Folder f where f.fname = :fname");
    query.setParameter("fname", fname);
    return (Collection<Folder>) query.getResultList();
  }

  @SuppressWarnings("unchecked")
  public Collection<Folder> findById(String userid, String fname) {
    Query query = entityManager.createQuery("select f from Folder f where f.userId = :userid and f.fname=:fname");
    query.setParameter("userid", userid);
    return (Collection<Folder>) query.getResultList();
  }

    @SuppressWarnings("unchecked")
    public Collection<Folder> findByUser(String username) {
        Query query = entityManager.createQuery("select f from Folder f where f.username = :username");
        query.setParameter("user", username);
        return (Collection<Folder>) query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Folder> findByTitleUser(String title, User user) {
        TypedQuery<Folder> query = entityManager.createQuery("SELECT a FROM Album a WHERE a.title = :title AND a.user = :user", Folder.class);
        query.setParameter("title", title);
        query.setParameter("user", user);
        return query.getResultList();
    }
}
