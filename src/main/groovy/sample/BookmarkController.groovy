package sample

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/bookmarks")
class BookmarkController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    def getBookmark(@PathVariable("id") Long id) {
        def bookmark = Bookmark.get(id)
        if (!bookmark) {
            return new ResponseEntity(HttpStatus.NOT_FOUND)
        }
        return bookmark.toMap()
    }

    @RequestMapping(method = RequestMethod.GET)
    def getBookmarks() {
        Bookmark.list().collect { it.toMap() }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    def postBookmarks(@RequestBody Bookmark bookmark) {
        Bookmark.withNewTransaction {
            if (!bookmark.save(flush: true)) {
                println "name: $name, url: $url"
                return new ResponseEntity(HttpStatus.BAD_REQUEST)
            }
            return new ResponseEntity(HttpStatus.CREATED)
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookmarks(@PathVariable("id") Long id) {
        Bookmark.get(id).delete()
    }
}

