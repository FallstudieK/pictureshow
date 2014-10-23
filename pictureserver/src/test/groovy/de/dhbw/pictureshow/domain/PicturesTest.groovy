package de.dhbw.pictureshow.domain

import spock.lang.Specification

/**
 * Created by koeppent on 23.10.2014.
 */
class PicturesTest extends Specification {

    def testPicturesId() { // tests need to start with test....
        when:   // do something
        Pictures picture= new Pictures();

        then: // then validate
        picture.id != null
    }
}
