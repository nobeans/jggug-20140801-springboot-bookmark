package sample

import org.springframework.data.jpa.repository.JpaRepository

interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    // nothing is required
}
