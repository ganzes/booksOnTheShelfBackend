package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.entities.Bookcase;
import booksontheshelfbackend.repositories.BookcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookcaseService {

    @Autowired
    private BookcaseRepository bookcaseRepository;

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

    public void addBooksToBookcase(final Set<Book> bookSet, final Long id){
        Bookcase updateBookcase = bookcaseRepository.findById(id).orElseThrow();
        for (Book book : bookSet) {
            updateBookcase.getBooks().add(book);
        }
        bookcaseRepository.save(updateBookcase);
    }
}
