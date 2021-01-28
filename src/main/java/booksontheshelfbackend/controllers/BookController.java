package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.mappers.BookMapper;
import booksontheshelfbackend.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping(value = "/book")
    private void createBook(@RequestBody BookDto bookDto) {
        logger.info("Started createBook in BookController.");

        bookMapper.mapToBookDto(bookService.createBook(bookMapper.mapToBook(bookDto)));
    }

    @PutMapping(value = "/book")
    private BookDto updateBook(@RequestBody BookDto bookDto) {
        logger.info("Started updateBook in BookController.");

        return bookMapper.mapToBookDto(bookService.updateBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping(value = "/book{id}")
    private BookDto getBook(@RequestParam Long id) {
        logger.info("Started getBook in BookController.");

        return bookMapper.mapToBookDto(bookService.findBookById(id));
    }

    @GetMapping(value = "/books")
    private List<BookDto> getAllBooks() {
        logger.info("Started getAllBooks in BookController.");

        return bookMapper.mapToBookDtoList(bookService.getAllBooks());
    }

    @DeleteMapping(value = "/book{id}")
    private void deleteBook(@RequestParam Long id) {
        logger.info("Started deleteBook in BookController.");

        bookService.deleteBook(id);
    }

    @PatchMapping(value = "/book{id}")
    private BookDto withdrawnBook(@RequestParam Long id) {
        logger.info("Started withdrawnBook in BookController.");

        BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));

        return bookMapper.mapToBookDto(bookService.withdrawnBook(bookMapper.mapToBook(bookDto)));
    }

    @GetMapping(value = "/booksc")
    private Long countBooks() {
        logger.info("Started withdrawnBook in BookController.");

        return bookService.countBooks();
    }

    @PatchMapping(value = "/changebookstatus{id&status}")
    private BookDto changeBookStatus(@RequestParam Long id, @RequestParam Long status) {
        logger.info("Started changeBookStatus in BookController.");
        BookDto bookDto = bookMapper.mapToBookDto(bookService.findBookById(id));

        return bookMapper.mapToBookDto(bookService.changeBookStatus(bookMapper.mapToBook(bookDto), status));
    }
}
