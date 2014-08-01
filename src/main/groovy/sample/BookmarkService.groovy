package sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BookmarkService {
    @Autowired
    BookmarkRepository bookmarkRepository

    Bookmark get(long id) throws ResourceNotFoundException {
        def bookmark = bookmarkRepository.findOne(id)
        if (!bookmark) {
            throw new ResourceNotFoundException()
        }
        return bookmark
    }

    List<Bookmark> findAll() {
        bookmarkRepository.findAll(new Sort(Sort.Direction.ASC, "id"))
    }

    Bookmark save(Bookmark bookmark) {
        bookmarkRepository.save(bookmark)
    }

    void delete(Long id) {
        bookmarkRepository.delete(id)
    }
}