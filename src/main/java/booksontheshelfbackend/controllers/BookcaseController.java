package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.BookcaseDto;
import booksontheshelfbackend.mappers.BookcaseMapper;
import booksontheshelfbackend.services.BookcaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/createBookcase")
    private void createBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started createBookcase in BookcaseController.");
        bookcaseMapper.mapToBookcaseDto(bookcaseService.createBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @PutMapping(value = "/updateBookcase")
    private BookcaseDto updateBookcase(@RequestBody BookcaseDto bookcaseDto) {
        logger.info("Started updateBookcase in BookcaseController.");
        return bookcaseMapper.mapToBookcaseDto(bookcaseService.updateBookcase(bookcaseMapper.mapToBookcase(bookcaseDto)));
    }

    @GetMapping(value = "/getAllBookcases")
    private List<BookcaseDto> getAllBookcases() {
        return bookcaseMapper.mapToBookcaseDtoList(bookcaseService.getAllBookcases());
    }

    @DeleteMapping(value = "/deleteBookcase")
    private void deleteBookcase(@RequestParam Long bookcaseId) {
        logger.info("Started deleteBookcase in BookcaseController.");
        bookcaseService.deleteBookcase(bookcaseId);
    }
}
