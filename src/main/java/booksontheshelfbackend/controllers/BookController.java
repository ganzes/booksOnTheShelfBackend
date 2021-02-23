package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookDto;
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

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private static final String INVALID = "Invalid ";
    private static final String SUCCESS = " succeed in BookController.";
    private static final String FAILED = " failed in BookController.";

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        logger.info("Started createBook in BookController.");
        try {
            logger.info("createBook " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.createBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("createBook " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/book")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        logger.info("Started updateBook in BookController.");
        try {
            logger.info("updateBook " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.updateBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("updateBook " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/book{id}")
    public ResponseEntity<BookDto> getBook(@RequestParam Long id) {
        logger.info("Started getBook in BookController.");
        try {
            logger.info("getBook " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.findBookById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getBook " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        logger.info("Started getAllBooks in BookController.");
        try {
            logger.info("getAllBooks " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.getAllBooks()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getAllBooks " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @DeleteMapping(value = "/book{id}")
    public ResponseEntity<Void> deleteBook(@RequestParam Long id) {
        logger.info("Started deleteBook in BookController.");
        try {
            bookService.deleteBook(id);
            logger.info("deleteBook " + SUCCESS);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | NoSuchElementException | HttpServerErrorException e) {
            logger.warn("deleteBook " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/book{id}")
    public ResponseEntity<BookDto> withdrawnBook(@RequestParam Long id) {
        logger.info("Started withdrawnBook in BookController.");
        try {
            BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));
            logger.info("withdrawnBook " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.withdrawnBook(bookMapper.mapToBook(bookDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("withdrawnBook " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/booksc")
    public ResponseEntity<Long> countBooks() {
        logger.info("Started countBooks in BookController.");
        try {
            logger.info("countBooks " + SUCCESS);
            return ResponseEntity.ok(bookService.countBooks());
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("countBooks " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/changebookstatus{id&status}")
    public ResponseEntity<BookDto> changeBookStatus(@RequestParam Long id, @RequestParam Long status) {
        logger.info("Started changeBookStatus in BookController.");
        try {
            BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));
            logger.info("changeBookStatus " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDto(bookService.changeBookStatus(bookMapper.mapToBook(bookDto), status)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("changeBookStatus " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/books{bookStatusEnum)}")
    public ResponseEntity<List<BookDto>> findBookByStatus(@RequestParam String bookStatus) {
        logger.info("Started findBookByStatus in BookController.");
        try {
            logger.info("findBookByStatus " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByStatus(bookStatus)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByStatus " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawnedtrue")
    public ResponseEntity<List<BookDto>> findBookByWithdrawnIsTrue() {
        logger.info("Started findBookByWithdrawnIsTrue in BookController.");
        try {
            logger.info("findBookByWithdrawnIsTrue " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawnIsTrue()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByWithdrawnIsTrue " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawnedfalse")
    public ResponseEntity<List<BookDto>> findBookByWithdrawnIsFalse() {
        logger.info("Started findBookByWithdrawnIsFalse in BookController.");
        try {
            logger.info("findBookByWithdrawnIsFalse " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawnIsFalse()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByWithdrawnIsFalse " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookswithdrawned{oneZero}")
    public ResponseEntity<List<BookDto>> findBookByWithdrawn(boolean oneZero) {
        logger.info("Started findBookByWithdrawn in BookController.");
        try {
            logger.info("findBookByWithdrawn " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByWithdrawn(oneZero)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByWithdrawn " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookbyauthor{author}")
    public ResponseEntity<List<BookDto>> findBookByAuthor(String author) {
        logger.info("Started findBookByAuthor in BookController.");
        try {
            logger.info("findBookByAuthor " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByAuthor(author)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByAuthor " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookbytitle{title}")
    public ResponseEntity<List<BookDto>> findBookByTitle(String title) {
        logger.info("Started findBookByTitle in BookController.");
        try {
            logger.info("findBookByTitle " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByTitle(title)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByTitle " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookbypublisher{publisher}")
    public ResponseEntity<List<BookDto>> findBookByPublisher(String publisher) {
        logger.info("Started findBookByPublisher in BookController.");
        try {
            logger.info("findBookByPublisher " + SUCCESS);
            return ResponseEntity.ok(bookMapper.mapToBookDtoList(bookService.findBookByPublisher(publisher)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookByPublisher " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}
