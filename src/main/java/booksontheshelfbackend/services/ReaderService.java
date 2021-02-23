package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Pages;
import booksontheshelfbackend.entities.Reader;
import booksontheshelfbackend.repositories.PagesRepository;
import booksontheshelfbackend.repositories.ReaderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    public static final Logger logger = LoggerFactory.getLogger(ReaderService.class);

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private PagesRepository pagesRepository;

    public List<Reader> getAllReaders() {
        logger.info("Started getAllReaders in ReaderService");

        return readerRepository.findAll();
    }

    public Reader createReader(Reader reader) {
        logger.info("Started createReader in ReaderService");

        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (optionalReader.isEmpty()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    public Reader updateReader(Reader reader) {
        logger.info("Started updateReader in ReaderService");

        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (optionalReader.isPresent()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    public Reader findReaderById(Long id) {
        logger.info("Started findReaderById in ReaderService");

        return readerRepository.findById(id).orElseThrow();
    }

    public void deleteReader(Long id) {
        logger.info("Started deleteReader in ReaderService");

        Reader deleteReader = readerRepository.findById(id).orElseThrow();
        readerRepository.delete(deleteReader);
    }

    public Reader addPagesToReader(final Long id, final Long numberOfPages) {
        logger.info("Started addPagesToReader in ReaderService");

        Reader optionalReader = readerRepository.findById(id).orElseThrow();

        Pages optionalPage = new Pages();
        optionalPage.setReader(optionalReader);
        optionalPage.setPagesRead(numberOfPages);
        pagesRepository.save(optionalPage);

        return readerRepository.save(optionalReader);
    }

    public Long countAllPagesInReader(final Long id) {
        logger.info("Started countAllPagesInReader in ReaderService");

        Reader optionalReader = readerRepository.findById(id).orElseThrow();
        return optionalReader.getPages().stream().mapToLong(Pages::getPagesRead).sum();
    }
}
