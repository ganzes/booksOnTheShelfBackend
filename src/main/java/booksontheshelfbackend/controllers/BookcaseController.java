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

    private static final Logger logger = LoggerFactory.getLogger(BookcaseController.class);
    private static final String INVALID = "Invalid ";
    private static final String SUCCESS = " succeed in BookcaseController.";
    private static final String FAILED = " failed in BookcaseController.";

    @Autowired
    private BookcaseMapper bookcaseMapper;

    @Autowired
    private BookcaseService bookcaseService;

    @PostMapping(value = "/bookcase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookcaseDto> createBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started createBookcase in BookcaseController.");

        try {
            if (!bookcaseService.existById(bookcaseDto.getId())) {
                logger.info("Bookcase does not exist in createBookcase in BookcaseController.");
                logger.info("createBookcase " + SUCCESS);
                return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDto
                        (bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto))));
            } else if (bookcaseService.existById(bookcaseDto.getId())){
                logger.warn("Failure createBookcase in BookcaseController, Bookcase exist.");
            }
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("createBookcase " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
        return null;
    }

    @PutMapping(value = "/bookcase")
    public BookcaseDto updateBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started updateBookcase in BookcaseController.");

        if (bookcaseDto.getId() == 0) {
            logger.info("0 updateBookcase in BookcaseController.");
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        } else if (bookcaseService.existById(bookcaseDto.getId())) {
            logger.info("EXIST");
            try {
                logger.info("updateBookcase " + SUCCESS);
                return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
            } catch (HttpServerErrorException e) {
                logger.error("Exception " + e);
                logger.warn("updateBookcase " + FAILED);
            }
        } else if (!bookcaseService.existById(bookcaseDto.getId())) {
            logger.info("NOT EXIST");
            logger.warn("updateBookcase " + FAILED);
            return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
        }

        logger.info("Ended updateBookcase in BookcaseController.");

        return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @GetMapping(value = "/bookcases")
    public ResponseEntity<List<BookcaseDto>> getAllBookcases() {
        logger.info("Started getAllBookcases in BookcaseController.");

        try {
            logger.info("getAllBookcases " + SUCCESS);
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDtoList(bookcaseService.getAllBookcases()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getAllBookcases " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/bookcase{id}")
    public ResponseEntity<BookcaseDto> getBookcase(@RequestParam Long id) {
        logger.info("Started getBookcase in BookcaseController.");

        try {
            logger.info("getBookcase " + SUCCESS);
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDto(bookcaseService.findBookcaseById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getBookcase " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @DeleteMapping(value = "/bookcase{id}")
    public ResponseEntity<Void> deleteBookcase(@RequestParam Long id) {
        logger.info("Started deleteBookcase in BookcaseController.");

        try {
            logger.info("deleteBookcase " + SUCCESS);
            bookcaseService.deleteBookcase(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("deleteBookcase " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/bookcasebook{bookId&id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookcaseDto> addBookToBookcase(@RequestParam Long id, @RequestParam Long bookId) {
        logger.info("Started addBookToBookcase in BookcaseController.");

        try {
            logger.info("addBookToBookcase " + SUCCESS);
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDto(bookcaseService.addBookToBookcase(id, bookId)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("addBookToBookcase " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/booksinbookcase")
    public ResponseEntity<Long> countBooksInBookcase(@RequestParam Long id) {
        logger.info("Started countBooksInBookcase in BookcaseController.");

        try {
            logger.info("countBooksInBookcase " + SUCCESS);
            return ResponseEntity.ok(bookcaseService.countBooksInBookcase(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("countBooksInBookcase " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/findbookcasebytag{tag}")
    public ResponseEntity<List<BookcaseDto>> findBookcaseByTag(@RequestParam String tag) {
        logger.info("Started findBookcaseByTag in BookcaseController.");

        try {
            logger.info("findBookcaseByTag " + SUCCESS);
            return ResponseEntity.ok(bookcaseMapper.mapToBookcaseDtoList(bookcaseService.findBookcaseByTag(tag)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("findBookcaseByTag " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}
