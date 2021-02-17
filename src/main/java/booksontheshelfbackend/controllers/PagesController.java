package booksontheshelfbackend.controllers;

import booksontheshelfbackend.dtos.PagesDto;
import booksontheshelfbackend.mappers.PagesMapper;
import booksontheshelfbackend.services.PagesService;
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
public class PagesController {

    private static final Logger logger = LoggerFactory.getLogger(PagesController.class);
    private static final String INVALID = "Invalid ";
    private static final String SUCCESS = " succeed in PagesController.";

    @Autowired
    private PagesMapper pagesMapper;

    @Autowired
    private PagesService pagesService;
    
    @GetMapping(value = "/pages")
    public ResponseEntity<List<PagesDto>> getAllPages() {
        logger.info("Started getAllPages in PagesController.");
        try {
            logger.info("getAllPages "+ SUCCESS);
            return ResponseEntity.ok(pagesMapper.mapToPagesDtoList(pagesService.getAllPages()));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed getAllPages ContactController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }

    @PostMapping(value = "/pages")
    public ResponseEntity<PagesDto> createPages(@RequestBody PagesDto pagesDto) {
        logger.info("Started createPages in PagesController.");
        try {
            logger.info("createPages "+ SUCCESS);
            return ResponseEntity.ok(pagesMapper.mapToPagesDto(pagesService.createPages
                    (pagesMapper.mapToPages(pagesDto))));
        } catch (ResponseStatusException | HttpServerErrorException e) {
            logger.warn("Failed createPages in PagesController!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, INVALID + e);
        }
    }
}
