package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.PICTURE;
import de.dhbw.pictureshow.domain.Pictures;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

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
}
