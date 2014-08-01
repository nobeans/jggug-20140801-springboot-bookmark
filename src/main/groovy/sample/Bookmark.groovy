package sample

import grails.persistence.Entity
import groovy.transform.ToString

@Entity
@ToString
class Bookmark {

    String name
    String url

    static constraints = {
        name blank: false, maxSize: 255
        url blank: false, maxSize: 255
    }

    String toMap() {
        return [name: name, url: url]
    }
}
