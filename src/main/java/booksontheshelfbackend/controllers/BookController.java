package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.entities.Book;
import booksontheshelfbackend.mappers.BookMapper;
import booksontheshelfbackend.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private static final String INVALID = "Invalid ";

    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        logger.info("Started createBook in BookController.");
        try {
            logger.info("Success createBook in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.createBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createBook in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/book")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        logger.info("Started updateBook in BookController.");
        try {
            logger.info("Success updateBook in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.updateBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateBook in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/book{id}")
    public ResponseEntity<BookDto> getBook(@RequestParam Long id) {
        logger.info("Started getBook in BookController.");
        try {
            logger.info("Success getBook in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.findBookById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getBook in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        logger.info("Started getAllBooks in BookController.");
        try {
            logger.info("Success getAllBooks in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.getAllBooks()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllBooks in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @DeleteMapping(value = "/book{id}")
    public ResponseEntity<Void> deleteBook(@RequestParam Long id) {
        logger.info("Started deleteBook in BookController.");
        try {
            bookService.deleteBook(id);
            logger.info("Success deleteBook in BookController.");
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | NoSuchElementException | HttpServerErrorException e) {
            logger.warn("Failed deleteBook in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/book/{id}")
    public ResponseEntity<BookDto> withdrawnBook(@RequestParam Long id) {
        logger.info("Started withdrawnBook in BookController.");
        try {
            BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));
            logger.info("Success withdrawnBook in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.withdrawnBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed withdrawnBook in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/booksc")
    public ResponseEntity<Long> countBooks() {
        logger.info("Started countBooks in BookController.");
        try {
            logger.info("Success countBooks in BookController.");
            return ResponseEntity.ok(bookService.countBooks());
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed countBooks in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/changebookstatus/{id&status}")
    public ResponseEntity<BookDto> changeBookStatus(@RequestParam Long id, @RequestParam Long status) {
        logger.info("Started changeBookStatus in BookController.");
        try {
            BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));
            logger.info("Success countBooks in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.changeBookStatus(bookMapper.mapToBook(bookDto), status)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed countBooks in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/books{bookStatusEnum)}")
    public ResponseEntity<List<BookDto>> findBookByStatus(@RequestParam String bookStatus) {
        logger.info("Started findBookByStatus in BookController.");
        try {
            logger.info("Success findBookByStatus in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByStatus(bookStatus)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByStatus in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawnedtrue")
    public ResponseEntity<List<BookDto>> findBookByWithdrawnIsTrue() {
        logger.info("Started findBookByWithdrawnIsTrue in BookController.");
        try {
            logger.info("Success findBookByWithdrawnIsTrue in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawnIsTrue()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByWithdrawnIsTrue in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawnedfalse")
    public ResponseEntity<List<BookDto>> findBookByWithdrawnIsFalse() {
        logger.info("Started findBookByWithdrawnIsFalse in BookController.");
        try {
            logger.info("Success findBookByWithdrawnIsFalse in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawnIsFalse()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByWithdrawnIsFalse in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawned{oneZero}")
    public ResponseEntity<List<BookDto>> findBookByWithdrawn(boolean oneZero) {
        logger.info("Started findBookByWithdrawn in BookController.");
        try {
            logger.info("Success findBookByWithdrawn in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawn(oneZero)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByWithdrawn in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookbyauthor{author}")
    public ResponseEntity<List<BookDto>> findBookByAuthor(String author) {
        logger.info("Started findBookByAuthor in BookController.");
        try {
            logger.info("Success findBookByAuthor in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByAuthor(author)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByAuthor in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookbytitle{title}")
    public ResponseEntity<List<BookDto>> findBookByTitle(String title) {
        logger.info("Started findBookByTitle in BookController.");
        try {
            logger.info("Success findBookByTitle in BookController.");
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByTitle(title)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed findBookByWithdrawnIsFalse in BookController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}
