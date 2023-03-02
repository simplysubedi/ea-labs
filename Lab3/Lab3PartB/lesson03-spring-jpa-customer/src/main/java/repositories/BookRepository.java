package repositories;

import domain.Book;
import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Customer> findAllByTitle(String title);
}
