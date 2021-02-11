package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.enums.BookStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    List<Book> findAll();

    List<Book> findBookByBookStatusEnum(String bookStatus);

    @Override
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
