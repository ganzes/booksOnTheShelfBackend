package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.enums.BookRatingEnum;
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

    List<Book> findBookByBookStatusEnum(BookStatusEnum bookStatusEnum);

    List<Book> findBookByWithdrawnIsTrue();

    List<Book> findBookByWithdrawnIsFalse();

    List<Book> findBookByWithdrawn(boolean oneZero);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByTitle(String title);

    List<Book> findBookByPublisher(String publisher);

    List<Book> findBookByBookRatingEnum(BookRatingEnum bookRatingEnum);

    @Override
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
