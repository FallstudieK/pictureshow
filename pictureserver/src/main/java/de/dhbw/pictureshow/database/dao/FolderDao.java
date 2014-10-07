package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Folder;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 */
@ApplicationScoped
public class FolderDao extends JpaDao<UuidId,Folder> {
    public FolderDao() {
        super(Folder.class);
    }

    @SuppressWarnings("unchecked")
    public Collection<Folder> findByName(String name) {
        Query query = entityManager.createQuery("select f from Folder f where f.name = :name");
        query.setParameter("name", name);
        return (Collection<Folder>)query.getResultList();
    }
}
