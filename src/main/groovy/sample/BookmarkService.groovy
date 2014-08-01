package sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface BookmarkService {
    List<Bookmark> findAll()

    Bookmark save(Bookmark bookmark)

    void delete(Long id)
}

@Service
@Transactional
class BookmarkServiceImpl implements BookmarkService {
    @Autowired
    BookmarkRepository bookmarkRepository

    List<Bookmark> findAll() {
        return bookmarkRepository.findAll(new Sort(Sort.Direction.ASC, "id"))
    }

    Bookmark save(Bookmark bookmark) {
        return bookmarkRepository.save(bookmark)
    }

    void delete(Long id) {
        bookmarkRepository.delete(id)
    }
}