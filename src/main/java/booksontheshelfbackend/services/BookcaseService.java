package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.repositories.BookRepository;
import booksontheshelfbackend.repositories.BookcaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookcaseService {

    public static final Logger logger = LoggerFactory.getLogger(BookcaseService.class);

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private BookRepository bookRepository;

    public Bookcase createBookcase(Bookcase bookcase) {
        logger.info("Started createBook in BookcaseService");

        Optional<Bookcase> optionalBookcase = bookcaseRepository.findById(bookcase.getId());
        if (optionalBookcase.isEmpty()) {
            return bookcaseRepository.save(bookcase);
        }
        return bookcase;
    }

    public List<Bookcase> getAllBookcases() {
        logger.info("Started getAllBookcases in BookcaseService");

        return bookcaseRepository.findAll();
    }

    public Bookcase findBookcaseById(Long bookcaseId) {
        logger.info("Started findBookcaseById in BookcaseService");

        return bookcaseRepository.findById(bookcaseId).orElseThrow();
    }

    public Bookcase updateBookcase(Bookcase bookcase) {
        logger.info("Started updateBookcase in BookcaseService");

        Optional<Bookcase> optionalBookcase = bookcaseRepository.findById(bookcase.getId());
        if (optionalBookcase.isPresent()) {
            return bookcaseRepository.save(bookcase);
        }
        return bookcase;
    }

    public void deleteBookcase(Long id) {
        logger.info("Started deleteBookcase in BookcaseService");

        Bookcase deleteBookcase = bookcaseRepository.findById(id).orElseThrow();
        bookcaseRepository.delete(deleteBookcase);
    }

    public Bookcase addBookToBookcase(final Long id, final Long bookId) {
        logger.info("Started addBookToBookcase in BookcaseService");

        Bookcase updateBookcase = bookcaseRepository.findById(id).orElseThrow();
        Book addBook = bookRepository.findById(bookId).orElse(null);
        assert addBook != null;
        addBook.setBookcase(updateBookcase);
        bookRepository.save(addBook);

        return bookcaseRepository.save(updateBookcase);
    }

    public Long countBooksInBookcase(final Long id) {
        logger.info("Started countBooksInBookcase in BookcaseService");

        Bookcase countBooks = bookcaseRepository.findById(id).orElseThrow();

        return (long) countBooks.getBooks().size();
    }

    public boolean existById(final Long id) {
        logger.info("Started existById in BookcaseService");

        return bookcaseRepository.existsById(id);
    }

    public List<Bookcase> findBookcaseByTag(final String tag) {
        logger.info("Started findBookcaseByTag in BookcaseService");

        return bookcaseRepository.findBookcaseByTag(tag);
    }
}
