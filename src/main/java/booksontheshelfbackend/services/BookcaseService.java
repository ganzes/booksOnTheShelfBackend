package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.repositories.BookRepository;
import booksontheshelfbackend.repositories.BookcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

    @Autowired
    private BookRepository bookRepository;

    public Bookcase createBookcase(Bookcase bookcase) {
        Optional<Bookcase> optionalBookcase = bookcaseRepository.findById(bookcase.getId());
        if (!optionalBookcase.isPresent()) {
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

/*    public void addBooksToBookcase(final Set<Book> bookSet, final Long id){
        Bookcase updateBookcase = bookcaseRepository.findById(id).orElseThrow();
        for (Book book : bookSet) {
            updateBookcase.getBooks().add(bookRepository.findById(book.getId()).get());
        }
        bookcaseRepository.save(updateBookcase);
    }*/

    public Bookcase addBookToBookcase(final Long id, final Long bookId){
        Bookcase updateBookcase = bookcaseRepository.findById(id).orElseThrow();
        System.out.println("PULKA KURDE " + updateBookcase.getTag());

        Book addBook = bookRepository.findById(bookId).get();
        System.out.println("ksiazka kurde " + addBook.getAuthor());

        Set<Book> bookHashSet = new HashSet<>();
        bookHashSet.add(addBook);
        //bookHashSet.add(new Book());
        System.out.println("CALOSC KURDE " + bookHashSet);

        updateBookcase.setBooks(bookHashSet);
        updateBookcase.getBooks();

        return bookcaseRepository.save(updateBookcase);
    }
}
