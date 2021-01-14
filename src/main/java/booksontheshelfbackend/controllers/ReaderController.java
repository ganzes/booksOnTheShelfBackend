package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.ReaderDto;
import booksontheshelfbackend.mappers.ReaderMapper;
import booksontheshelfbackend.services.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/createReader")
    private void createReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started createReader in ReaderController.");
        readerMapper.mapToReaderDto(readerService.createReader(readerMapper.mapToReader(readerDto)));
    }

    @PutMapping(value = "/updateReader")
    private ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        logger.info("Started updateReader in ReaderController.");
        return readerMapper.mapToReaderDto(readerService.updateReader(readerMapper.mapToReader(readerDto)));
    }

    @GetMapping(value = "/getAllReaders")
    private List<ReaderDto> getAllReaders() {
        return readerMapper.mapToReaderDtoList(readerService.getAllReaders());
    }

    @DeleteMapping(value = "/deleteReader")
    private void deleteReader(@RequestParam Long readerId) {
        logger.info("Started deleteReader in ReaderController.");
        readerService.deleteReader(readerId);
    }
}