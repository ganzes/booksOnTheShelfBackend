package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.repositories.BookRepository;
import booksontheshelfbackend.repositories.BookcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private BookRepository bookRepository;

    public Bookcase createBookcase(Bookcase bookcase) {
        Optional<Bookcase> optionalBookcase = bookcaseRepository.findById(bookcase.getId());
        if (optionalBookcase.isEmpty()) {
            return bookcaseRepository.save(bookcase);
        }
        return bookcase;
    }

    public List<Bookcase> getAllBookcases() {
        return bookcaseRepository.findAll();
    }

    public Bookcase findBookcaseById(Long bookcaseId) {
        return bookcaseRepository.findById(bookcaseId).orElseThrow();
    }

    public Bookcase updateBookcase(Bookcase bookcase) {
        Optional<Bookcase> optionalBookcase = bookcaseRepository.findById(bookcase.getId());
        if (optionalBookcase.isPresent()) {
            return bookcaseRepository.save(bookcase);
        }
        return bookcase;
    }

    public void deleteBookcase(Long id) {
        Bookcase deleteBookcase = bookcaseRepository.findById(id).orElseThrow();
        bookcaseRepository.delete(deleteBookcase);
    }

    public Bookcase addBookToBookcase(final Long id, final Long bookId){
        Bookcase updateBookcase = bookcaseRepository.findById(id).orElseThrow();
        Book addBook = bookRepository.findById(bookId).orElse(null);
        assert addBook != null;
        addBook.setBookcase(updateBookcase);
        bookRepository.save(addBook);

        return bookcaseRepository.save(updateBookcase);
    }

    public Long countBooksInBookcase(final Long id){
        Bookcase countBooks = bookcaseRepository.findById(id).orElseThrow();

        return (long) countBooks.getBooks().size();
    }

    public boolean existById(final Long id){
        return bookcaseRepository.existsById(id);
    }

    public List<Bookcase> findBookcaseByTag(final String tag){
        return bookcaseRepository.findBookcaseByTag(tag);
    }
}
