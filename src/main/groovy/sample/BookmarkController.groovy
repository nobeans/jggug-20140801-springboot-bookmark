package sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/bookmarks")
class BookmarkController {
    @Autowired
    BookmarkService bookmarkService

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Bookmark getBookmark(@PathVariable("id") Long id) {
        bookmarkService.get(id)
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Bookmark> getBookmarks() {
        bookmarkService.findAll()
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Bookmark postBookmarks(@Validated @RequestBody Bookmark bookmark) {
        bookmarkService.save(bookmark)
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBookmarks(@PathVariable("id") Long id) {
        bookmarkService.delete(id)
    }
}

