package de.dhbw.pictureshow.database.dao

import de.dhbw.pictureshow.domain.Pictures
import de.dhbw.pictureshow.domain.UuidId
import spock.lang.Specification

/**
 * Created by koeppent on 23.10.2014.
 */
class PicturesDaoTest extends Specification {

    @Delegate // a special form of inheritance
    DbTestUtil dbTestUtil = new DbTestUtil()

    private Pictures createPictures(PicturesDao dao, String title) {
        Pictures p = new Pictures();
        p.title = title
        dao.persist(p);
        p
    }


    def testPersistence() {
        setup:
        PicturesDao dao = new PicturesDao()

        when:
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        Pictures p = createPictures(dao, "YOP")
        dbTestUtil.em.getTransaction().commit();

        then:
        dbTestUtil.em.contains(p)
    }

    def testRead() {
        setup:
        PicturesDao dao = new PicturesDao()
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        Pictures p = createPictures(dao, "YOP")
        UuidId id = p.id
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        Pictures foundPictures = dao.get(id)

        then:
        foundPictures
        foundPictures.id == id
        foundPictures.title == "YOP"
    }

    def testFindByTitle() {
        setup:
        PicturesDao dao = new PicturesDao()

        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        createPictures(dao, "u1")
        Pictures expectedPictures = createPictures(dao, "u2")
        createPictures(dao, "u3")
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        Collection<Pictures> foundPictures = dao.findByTitle("u2")

        then:
        foundPictures
        foundPictures.size() == 1
        foundPictures[0].id == expectedPictures.id
    }
}
