package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.dtos.BookcaseDto;
import booksontheshelfbackend.mappers.BookMapper;
import booksontheshelfbackend.mappers.BookcaseMapper;
import booksontheshelfbackend.services.BookcaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookcaseController {

    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Autowired
    private BookcaseService bookcaseService;

    @Autowired
    private BookMapper bookMapper;

    private static final Logger logger = LoggerFactory.getLogger(BookcaseController.class);

    @PostMapping(value = "/bookcase", consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started createBookcase in BookcaseController.");
        bookcaseMapper.mapToBookcaseDto(bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @PutMapping(value = "/bookcase")
    private BookcaseDto updateBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started updateBookcase in BookcaseController.");
        return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @GetMapping(value = "/bookcases")
    private List<BookcaseDto> getAllBookcases() {
        logger.info("Started getAllBookcases in BookcaseController.");
        return bookcaseMapper.mapToBookcaseDtoList(bookcaseService.getAllBookcases());
    }

    @GetMapping(value = "/bookcase{id}")
    private BookcaseDto getBookcase(@RequestParam Long id) {
        logger.info("Started getBookcase in BookcaseController.");
        return bookcaseMapper.mapToBookcaseDto(bookcaseService.findBookcaseById(id));
    }

    @DeleteMapping(value = "/bookcase/{id}")
    private void deleteBookcase(@RequestParam Long id) {
        logger.info("Started deleteBookcase in BookcaseController.");
        bookcaseService.deleteBookcase(id);
    }

    @PutMapping(value = "/bookcase{id}")
    private void addBooksToBookcase(@RequestBody Set<BookDto> bookDtoSet, @RequestParam long id){
        logger.info("Started addBooksToBookcase in BookcaseController.");
        bookcaseService.addBooksToBookcase(bookMapper.mapToBookSet(bookDtoSet), id);
    }

}
