package sample

import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@ToString
class Bookmark {
    @Id
    @GeneratedValue
    Long id

    @NotNull
    @Size(min = 1, max = 255)
    String name

    @NotNull
    @Size(min = 1, max = 255)
    @org.hibernate.validator.constraints.URL
    String url
}
