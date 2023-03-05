package repositories;

import domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("update Book b set b.locationCode=:locationCode+b.locationCode")
    int updateBook(String locationCode);

    @Modifying
    @Transactional
    @Query("delete Book b where b.publicationYear<1950")
    int deleteBook();
}
