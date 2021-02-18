package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Pages;
import booksontheshelfbackend.repositories.PagesRepository;
import booksontheshelfbackend.repositories.ReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagesService {

    public static final Logger logger = LoggerFactory.getLogger(PagesService.class);

    @Autowired
    private PagesRepository pagesRepository;

    @Autowired
    private ReaderRepository readerRepository;

    public List<Pages> getAllPages() {
        logger.info("Started getAllPages in PagesRepository");

        return pagesRepository.findAll();
    }

    public Pages createPages(Pages pages) {
        logger.info("Started createPages in PagesRepository");

        Optional<Pages> optionalPages = pagesRepository.findById(pages.getId());
        if (optionalPages.isEmpty()) {
            return pagesRepository.save(pages);
        }
        return pages;
    }

    public Pages updatePages(Pages pages) {
        logger.info("Started updatePages in PagesRepository");

        Optional<Pages> optionalPages = pagesRepository.findById(pages.getId());
        if (optionalPages.isPresent()) {
            return pagesRepository.save(pages);
        }
        return pages;
    }

    public Pages findPagesById(Long id) {
        logger.info("Started findPagesById in PagesRepository");

        return pagesRepository.findById(id).orElseThrow();
    }

    public void deletePages(Long id) {
        logger.info("Started deletePages in PagesRepository");

        Pages deletePages = pagesRepository.findById(id).orElseThrow();
        pagesRepository.delete(deletePages);
    }

}