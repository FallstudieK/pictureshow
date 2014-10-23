package de.dhbw.pictureshow.domain

import spock.lang.Specification

/**
 *
 */
class FolderTest extends Specification {

    def testFolderId() { // tests need to start with test....
        when:   // do something
        Folder folder = new Folder();

        then: // then validate
        folder.id != null
    }
}
