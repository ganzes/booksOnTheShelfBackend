package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (!optionalBook.isPresent()) {
            return bookRepository.save(book);
        }
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public Book updateBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isPresent()) {
            return bookRepository.save(book);
        }
        return book;
    }

    public void deleteBook(Long id) {
        Book deleteBook = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(deleteBook);
    }

    public Book withdrawnBook(Book book) {
        if (!bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }
        bookRepository.findById(book.getId()).ifPresent
                (withdrawn -> book.setWithdrawn(!withdrawn.isWithdrawn()));
        return book;
    }
}
