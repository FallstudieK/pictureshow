package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Folder
import de.dhbw.pictureshow.domain.UuidId
import spock.lang.Specification

/**
 *
 */
class FolderDaoTest extends Specification {

    @Delegate // a special form of inheritance
    DbTestUtil dbTestUtil = new DbTestUtil()

    private Folder createFolder(FolderDao dao, String name) {
        Folder f = new Folder();
        f.fname = name
        dao.persist(f);
        f
    }


    def testPersistence() {
        setup:
        FolderDao dao = new FolderDao()

        when:
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        Folder f = createFolder(dao, "YOP")
        dbTestUtil.em.getTransaction().commit();

        then:
        dbTestUtil.em.contains(f)
    }

    def testRead() {
        setup:
        FolderDao dao = new FolderDao()
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        Folder f = createFolder(dao, "YOP")
        UuidId id = f.id
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        Folder foundFolder = dao.get(id)

        then:
        foundFolder
        foundFolder.id == id
        foundFolder.fname == "YOP"
    }

    def testFindByName() {
        setup:
        FolderDao dao = new FolderDao()

        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        createFolder(dao, "u1")
        Folder expectedFolder = createFolder(dao, "u2")
        createFolder(dao, "u3")
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        Collection<Folder> foundFolder = dao.findByName("u2")

        then:
        foundFolder
        foundFolder.size() == 1
        foundFolder[0].id == expectedFolder.id
    }
}
