package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.ReaderDto;
import booksontheshelfbackend.mappers.ReaderMapper;
import booksontheshelfbackend.services.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/botsab")
public class ReaderController {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private ReaderService readerService;

    private static final Logger logger = LoggerFactory.getLogger(ReaderController.class);
    private static final String INVALID = "Invalid ";

    @PostMapping(value = "/reader")
    public ResponseEntity<ReaderDto> createReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started createReader in ReaderController.");
        try {
            logger.info("Success createReader in ReaderController.");
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.createReader
                    (readerMapper.mapToReader(readerDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createReader in ReaderController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PutMapping(value = "/reader")
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started updateReader in ReaderController.");
        try {
            logger.info("Success updateReader in ReaderController.");
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.updateReader
                    (readerMapper.mapToReader(readerDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed updateReader ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/readers")
    public ResponseEntity<List<ReaderDto>> getAllReaders() {
        logger.info("Started getAllReaders in ReaderController.");
        try {
            logger.info("Success getAllReaders in ReaderController.");
            return ResponseEntity.ok(readerMapper.mapToReaderDtoList(readerService.getAllReaders()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllReaders ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @GetMapping(value = "/reader{id}")
    public ResponseEntity<ReaderDto> getReader(@RequestParam Long id) {
        logger.info("Started getReader in BookController.");
        try {
            logger.info("Started getReader in BookController.");
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.findReaderById(id)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getReader ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @DeleteMapping(value = "/reader{id}")
    public ResponseEntity<?> deleteReader(@RequestParam Long id) {
        logger.info("Started deleteReader in ReaderController.");
        try {
            logger.info("Started deleteReader in ReaderController.");
            readerService.deleteReader(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed deleteReader ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PatchMapping(value = "/reader{id&numberOfPages}")
    public ResponseEntity<?> addPagesToReader(@RequestParam Long id, @RequestParam Long numberOfPages) {
        logger.info("Started addPagesToReader in ReaderController.");
        try {
            logger.info("Success addPagesToReader in ReaderController.");
            return ResponseEntity.ok(readerMapper.mapToReaderDto(readerService.addPagesToReader(id, numberOfPages)));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed addPagesToReader ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}