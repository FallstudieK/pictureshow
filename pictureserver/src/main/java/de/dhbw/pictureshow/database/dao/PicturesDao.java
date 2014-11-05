package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.Pictures;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

/**
 * Created by koeppent on 20.10.2014.
 */
@ApplicationScoped
public class PicturesDao extends JpaDao<UuidId, Pictures> {
  public PicturesDao() {
    super(Pictures.class);
  }

  @SuppressWarnings("unchecked")
  public Collection<Pictures> findByTitle(String title) {
    Query query = entityManager.createQuery("select p from Pictures p where p.title = :title");
    query.setParameter("title", title);
    return (Collection<Pictures>) query.getResultList();
  }

  @SuppressWarnings("unchecked")
  public Collection<Pictures> findByUser(String user) {
    Query query = entityManager.createQuery("select p from Pictures p where p.username = :user");
    query.setParameter("user", user);
    return (Collection<Pictures>) query.getResultList();
  }

  @SuppressWarnings("unchecked")
  public Collection<Pictures> findByFolder(String folder) {
    Query query = entityManager.createQuery("select p from Pictures p where p.foldername = :foldername");
    query.setParameter("foldername", folder);
    return (Collection<Pictures>) query.getResultList();
  }
    @SuppressWarnings("unchecked")
    public List<Pictures> findByAlbum(Folder album) {
        TypedQuery<Pictures> query = entityManager.createQuery("SELECT b FROM Bild b WHERE b.album = :album", Pictures.class);
        query.setParameter("album", album);
        return query.getResultList();
    }

}
