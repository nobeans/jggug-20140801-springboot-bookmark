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

    Bookmark get(long id) {
        bookmarkRepository.findOne(id)
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