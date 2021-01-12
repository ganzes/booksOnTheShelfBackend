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

    private List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    private Book createBook(Book book){
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (!optionalBook.isPresent()){
            return bookRepository.save(book);
        }
        return book;
    }

    private Book updateBook(Book book){
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isPresent()){
            return bookRepository.save(book);
        }
        return book;
    }

    private void deleteBook(Long id){
        Book deleteBook = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(deleteBook);
    }

    private Book findBookById(Long bookId){
        return bookRepository.findById(bookId).orElseThrow();
    }
}
