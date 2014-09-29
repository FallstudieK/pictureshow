package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.PICTURE;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 */
@ApplicationScoped
public class PictureDao extends JpaDao<UuidId,PICTURE> {
    public PictureDao() {
        super(PICTURE.class);
    }

    @SuppressWarnings("unchecked")
    public Collection<PICTURE> findByTitle(String title) {
        Query query = entityManager.createQuery("select p from PICTURE p where p.title = :title");
        query.setParameter("title", title);
        return (Collection<PICTURE>)query.getResultList();
    }
}