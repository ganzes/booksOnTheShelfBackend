package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookcaseDto;
import booksontheshelfbackend.mappers.BookcaseMapper;
import booksontheshelfbackend.services.BookcaseService;
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

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class BookcaseController {

    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Autowired
    private BookcaseService bookcaseService;

    private static final Logger logger = LoggerFactory.getLogger(BookcaseController.class);

    @PostMapping(value = "/bookcase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private void createBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started createBookcase in BookcaseController.");
        try {
            if (!bookcaseService.existById(bookcaseDto.getId())) {
                logger.info("Bookcase does not exist in createBookcase in BookcaseController.");
                logger.info("Succeed createBookcase in BookcaseController.");
                ResponseEntity.ok(bookcaseMapper.mapToBookcaseDto
                        (bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto))));
            } else {
                logger.warn("Failure createBookcase in BookcaseController, Bookcase exist.");
            }
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createBookcase in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/bookcase")
    private BookcaseDto updateBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started updateBookcase in BookcaseController.");
        if (bookcaseDto.getId() == 0) {
            logger.info("0 updateBookcase in BookcaseController.");
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        } else if (bookcaseService.existById(bookcaseDto.getId())) {
            logger.info("EXIST");
            try {
                logger.info("Succeed updateBookcase in BookcaseController.");
                return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
            } catch (HttpServerErrorException e) {
                logger.error("Exception " + e);
                logger.warn("Failure updateBookcase in BookcaseController.");
            }
        } else if (!bookcaseService.existById(bookcaseDto.getId())) {
            logger.info("NOT EXIST");
            logger.warn("Failure updateBookcase in BookcaseController.");
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        }

        logger.info("Ended updateBookcase in BookcaseController.");
        return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @GetMapping(value = "/bookcases")
    private ResponseEntity<List<BookcaseDto>> getAllBookcases() {
        logger.info("Started getAllBookcases in BookcaseController.");
        try {
            logger.warn("Succeed getAllBookcases in BookcaseController!");
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDtoList(bookcaseService.getAllBookcases()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllBookcases in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/bookcase{id}")
    private ResponseEntity<BookcaseDto> getBookcase(@RequestParam Long id) {
        logger.info("Started getBookcase in BookcaseController.");
        try {
            logger.info("Succeed getBookcase in BookcaseController.");
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDto(bookcaseService.findBookcaseById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getBookcase in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @DeleteMapping(value = "/bookcase{id}")
    private void deleteBookcase(@RequestParam Long id) {
        logger.info("Started deleteBookcase in BookcaseController.");
        try {
            logger.info("Succeed deleteBookcase in BookcaseController.");
            bookcaseService.deleteBookcase(id);
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteBookcase in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @PutMapping(value = "/bookcasebook{bookId&id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> addBookToBookcase(@RequestParam Long id, @RequestParam Long bookId) {
        logger.info("Started addBookToBookcase in BookcaseController.");
        try {
            logger.info("Succeed addBookToBookcase in BookcaseController.");
            return ResponseEntity.ok(bookcaseService.addBookToBookcase(id, bookId));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed addBookToBookcase in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }

    @GetMapping(value = "/booksinbookcase")
    private ResponseEntity<?> countBooksInBookcase(@RequestParam Long id) {
        logger.info("Started countBooksInBookcase in BookcaseController.");
        try {
            logger.info("Succeed countBooksInBookcase in BookcaseController.");
            return ResponseEntity.ok(bookcaseService.countBooksInBookcase(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed countBooksInBookcase in BookcaseController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid " + e);
        }
    }
}
