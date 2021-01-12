package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.mappers.BookMapper;
import booksontheshelfbackend.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping(value = "createBook")
    private void createBook(@RequestBody BookDto bookDto) {
        logger.info("Started createBook in BookController.");
        bookMapper.mapToBookDto(bookService.createBook(bookMapper.mapToBook(bookDto)));
    }

    @DeleteMapping(value = "/deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        logger.info("Started deleteBook in BookController.");
        bookService.deleteBook(bookId);
    }
}
