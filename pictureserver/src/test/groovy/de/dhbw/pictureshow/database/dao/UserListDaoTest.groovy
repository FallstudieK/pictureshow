package de.dhbw.pictureshow.database.dao

import de.dhbw.pictureshow.domain.Pictures
import de.dhbw.pictureshow.domain.UuidId
import org.h2.engine.User
import spock.lang.Specification

/**
 * Created by koeppent on 23.10.2014.
 */
class UserListDaoTest extends Specification {

    @Delegate // a special form of inheritance
    DbTestUtil dbTestUtil = new DbTestUtil()

    private User createUser(UserListDao dao, String name) {
        User u = new User();
        u.name = name
        dao.persist(u);
        u
    }


    def testPersistence() {
        setup:
        UserListDao dao = new UserListDao()

        when:
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        User u = createUser(dao, "YOP")
        dbTestUtil.em.getTransaction().commit();

        then:
        dbTestUtil.em.contains(u)
    }

    def testRead() {
        setup:
        UserListDao dao = new UserListDao()
        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        User u = createUser(dao, "YOP")
        UuidId id = u.id
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        User foundUser = dao.get(id)

        then:
        foundUser
        foundUser.id == id
        foundUser.name == "YOP"
    }

    def testFindByName() {
        setup:
        UserListDao dao = new UserListDao()

        dbTestUtil.em.getTransaction().begin();
        dao.entityManager = dbTestUtil.em
        createUser(dao, "u1")
        User expectedPictures = createUser(dao, "u2")
        createUser(dao, "u3")
        dbTestUtil.em.getTransaction().commit();
        dbTestUtil.em.close()
        dbTestUtil.createEntityManager() // open clean session to avoid side effects
        dao.entityManager = dbTestUtil.em // make sure we use the new one...

        when:
        Collection<User> foundUser= dao.findByName("u2")

        then:
        foundUser
        foundUser.size() == 1
        foundUser[0].id == expectedPictures.id
    }
}
