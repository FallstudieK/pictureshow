package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

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
}
