package sample

import groovy.transform.ToString
import grails.persistence.*

@Entity
@ToString
class Bookmark {

    String name
    String url

    static constraints = {
        name blank: false, maxSize: 255
        url blank: false, maxSize: 255
    }
}
