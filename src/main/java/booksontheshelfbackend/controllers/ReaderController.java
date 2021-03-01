package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.ReaderDto;
import booksontheshelfbackend.mappers.ReaderMapper;
import booksontheshelfbackend.services.ReaderService;
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
public class ReaderController {

    private static final Logger logger = LoggerFactory.getLogger(ReaderController.class);
    private static final String INVALID = "Invalid ";
    private static final String SUCCESS = " succeed in ReaderController.";
    private static final String FAILED = " failed in BookController.";

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private ReaderService readerService;

    @PostMapping(value = "/reader")
    public ResponseEntity<ReaderDto> createReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started createReader in ReaderController.");

        try {
            logger.info("createReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.createReader
                    (readerMapper.mapToReader(readerDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("createReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/reader")
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started updateReader in ReaderController.");

        try {
            logger.info("updateReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.updateReader
                    (readerMapper.mapToReader(readerDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("updateReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/readers")
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        logger.info("Started getAllReaders in ReaderController.");

        try {
            logger.info("getAllReaders " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDtoList(readerService.getAllReaders()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getAllReaders " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/reader{id}")
    public ResponseEntity<ReaderDto> getReader(@RequestParam Long id) {
        logger.info("Started getReader in BookController.");

        try {
            logger.info("getReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.findReaderById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("getReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @DeleteMapping(value = "/reader{id}")
    public ResponseEntity<Void> deleteReader(@RequestParam Long id) {
        logger.info("Started deleteReader in ReaderController.");

        try {
            logger.info("deleteReader " + SUCCESS);
            readerService.deleteReader(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("deleteReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/reader{id&numberOfPages}")
    public ResponseEntity<ReaderDto> addPagesToReader(@RequestParam Long id, @RequestParam Long numberOfPages) {
        logger.info("Started addPagesToReader in ReaderController.");

        try {
            logger.info("addPagesToReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.addPagesToReader(id, numberOfPages)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("addPagesToReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/readercountpagesread{id}")
    public ResponseEntity<Long> countPagesReadInReader(@RequestParam Long id) {
        logger.info("Started countPagesReadInReader in ReaderController.");

        try {
            logger.info("countPagesReadInReader " + SUCCESS);
            return ResponseEntity.ok(readerService.countAllPagesInReader(id));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("countPagesReadInReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/addbooktoreader{bookId&id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReaderDto> addBookToReader(@RequestParam Long id, @RequestParam Long bookId) {
        logger.info("Started addBookToReader in ReaderController.");

        try {
            logger.info("addBookToReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.addBookToReader(id, bookId)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("addBookToReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/addbookcasetoreader{bookId&id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReaderDto> addBookcaseToReader(@RequestParam Long id, @RequestParam Long bookcaseId) {
        logger.info("Started addBookcaseToReader in ReaderController.");

        try {
            logger.info("addBookcaseToReader " + SUCCESS);
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.addBookcaseToReader(id, bookcaseId)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("addBookcaseToReader " + FAILED);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}