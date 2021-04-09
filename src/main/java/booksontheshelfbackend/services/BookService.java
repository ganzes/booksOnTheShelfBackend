package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.enums.BookRatingEnum;
import booksontheshelfbackend.enums.BookStatusEnum;
import booksontheshelfbackend.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        logger.info("Started createBook in BookService");

        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isEmpty()) {
            return bookRepository.save(book);
        }
        return book;
    }

    public List<Book> getAllBooks() {
        logger.info("Started getAllBooks in BookService");

        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId) {
        logger.info("Started findBookById in BookService");

        return bookRepository.findById(bookId).orElseThrow();
    }

    public Book updateBook(Book book) {
        logger.info("Started updateBook in BookService");

        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isPresent()) {
            return bookRepository.save(book);
        }
        return book;
    }

    public void deleteBook(Long id) {
        logger.info("Started deleteBook in BookService");

        Book deleteBook = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(deleteBook);
    }

    public Book withdrawnBook(Book book) {
        logger.info("Started withdrawnBook in BookService");

        if (!bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }
        bookRepository.findById(book.getId()).ifPresent
                (withdrawn -> book.setWithdrawn(!withdrawn.isWithdrawn()));
        return bookRepository.save(book);
    }

    public Long countBooks() {
        logger.info("Started countBooks in BookService");

        return bookRepository.count();
    }

    public Book changeBookStatus(Book book, int status) {
        logger.info("Started changeBookStatus in BookService");

        if (!bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }

        Book updateBook = bookRepository.findById(book.getId()).orElseThrow();

        if (status == 1) {
            updateBook.setBookStatusEnum(BookStatusEnum.TOREAD);
        } else if (status == 2) {
            updateBook.setBookStatusEnum(BookStatusEnum.DONEREAD);
        } else if (status == 3) {
            updateBook.setBookStatusEnum(BookStatusEnum.READING);
        }

        return bookRepository.save(updateBook);
    }

    public Book changeBookRating(Book book, int rating) {
        logger.info("Started changeBookRating in BookService");

        if (!bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }

        Book updateBook = bookRepository.findById(book.getId()).orElseThrow();
        switch (rating) {
            case 1:
                updateBook.setBookRatingEnum(BookRatingEnum.ONE);
                break;
            case 2:
                updateBook.setBookRatingEnum(BookRatingEnum.TWO);
                break;
            case 3:
                updateBook.setBookRatingEnum(BookRatingEnum.THREE);
                break;
            case 4:
                updateBook.setBookRatingEnum(BookRatingEnum.FOUR);
                break;
            case 5:
                updateBook.setBookRatingEnum(BookRatingEnum.FIVE);
                break;
            case 6:
                updateBook.setBookRatingEnum(BookRatingEnum.SIX);
                break;
            case 7:
                updateBook.setBookRatingEnum(BookRatingEnum.SEVEN);
                break;
            case 8:
                updateBook.setBookRatingEnum(BookRatingEnum.EIGHT);
                break;
            case 9:
                updateBook.setBookRatingEnum(BookRatingEnum.NINE);
                break;
            case 10:
                updateBook.setBookRatingEnum(BookRatingEnum.TEN);
                break;
        }

        return bookRepository.save(updateBook);
    }

    public List<Book> findBookByStatus(BookStatusEnum bookStatus) {
        logger.info("Started findBookByStatus in BookService");

        return bookRepository.findBookByBookStatusEnum(bookStatus);
    }

    public List<Book> findBookByWithdrawnIsTrue() {
        logger.info("Started findBookByWithdrawnIsTrue in BookService");

        return bookRepository.findBookByWithdrawnIsTrue();
    }

    public List<Book> findBookByWithdrawnIsFalse() {
        logger.info("Started findBookByWithdrawnIsFalse in BookService");

        return bookRepository.findBookByWithdrawnIsFalse();
    }

    public List<Book> findBookByWithdrawn(boolean oneZero) {
        logger.info("Started findBookByWithdrawn in BookService");

        return bookRepository.findBookByWithdrawn(oneZero);
    }

    public List<Book> findBookByAuthor(String author) {
        logger.info("Started findBookByAuthor in BookService");

        return bookRepository.findBookByAuthor(author);
    }

    public List<Book> findBookByTitle(String title) {
        logger.info("Started findBookByTitle in BookService");

        return bookRepository.findBookByTitle(title);
    }

    public List<Book> findBookByPublisher(String publisher) {
        logger.info("Started findBookByPublisher in BookService");

        return bookRepository.findBookByPublisher(publisher);
    }

    public List<Book> findBookByBookRating(BookRatingEnum rating) {
        logger.info("Started findBookByBookRating in BookService");

        return bookRepository.findBookByBookRatingEnum(rating);
    }

}
