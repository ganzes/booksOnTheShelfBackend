package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookcaseDto;
import booksontheshelfbackend.mappers.BookcaseMapper;
import booksontheshelfbackend.services.BookcaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookcaseController {

    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Autowired
    private BookcaseService bookcaseService;

    private static final Logger logger = LoggerFactory.getLogger(BookcaseController.class);

    @PostMapping(value = "/bookcase", consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started createBookcase in BookcaseController.");

        if (bookcaseDto.getId() == 0){
            logger.info("0 createBookcase in BookcaseController.");
            bookcaseMapper.mapToBookcaseDto(bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        }

        try {
            bookcaseMapper.mapToBookcaseDto(bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
            logger.info("Succeed createBookcase in BookcaseController.");
        } catch (HttpServerErrorException e) {
            logger.error("HttpServerErrorException " + e);
            logger.warn("Failure createBookcase in BookcaseController.");
        }
        logger.info("Ended createBookcase in BookcaseController.");
    }

    @PutMapping(value = "/bookcase")
    private BookcaseDto updateBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started updateBookcase in BookcaseController.");
        if (bookcaseDto.getId() == 0){
            logger.info("0 updateBookcase in BookcaseController.");
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        } else if(bookcaseService.existById(bookcaseDto.getId())){
            logger.info("EXIST");
            try {
                logger.info("Succeed updateBookcase in BookcaseController.");
                return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
            } catch (HttpServerErrorException e) {
                logger.error("Exception " + e);
                logger.warn("Failure updateBookcase in BookcaseController.");
            }
        } else if (!bookcaseService.existById(bookcaseDto.getId())){
            logger.info("NOT EXIST");
            logger.warn("Failure updateBookcase in BookcaseController.");
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        }

        logger.info("Ended updateBookcase in BookcaseController.");
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

    @DeleteMapping(value = "/bookcase{id}")
    private void deleteBookcase(@RequestParam Long id) {
        logger.info("Started deleteBookcase in BookcaseController.");

        bookcaseService.deleteBookcase(id);
    }

   /* @PutMapping(value = "/bookcasebook{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void addBooksToBookcase(@RequestParam long id, @RequestBody Set<BookDto> bookDtoSet){
        logger.info("Started addBooksToBookcase in BookcaseController.");
        bookcaseService.addBooksToBookcase(bookMapper.mapToBookSet(bookDtoSet), id);
    }*/

    @PutMapping(value = "/bookcasebook{bookId&id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private void addBookToBookcase(@RequestParam long id, @RequestParam long bookId) {
        logger.info("Started addBookToBookcase in BookcaseController.");

        bookcaseService.addBookToBookcase(id, bookId);
    }

    @GetMapping(value = "/booksinbookcase")
    private Long countBooksInBookcase(@RequestParam Long id) {
        logger.info("Started countBooksInBookcase in BookcaseController.");

        return bookcaseService.countBooksInBookcase(id);
    }


}
