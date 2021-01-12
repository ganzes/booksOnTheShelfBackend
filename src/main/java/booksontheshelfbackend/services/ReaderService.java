package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Reader;
import booksontheshelfbackend.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    private List<Reader> getAllReader() {
        return readerRepository.findAll();
    }

    private Reader createReader(Reader reader) {
        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (!optionalReader.isPresent()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    private Reader updateReader(Reader reader) {
        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (optionalReader.isPresent()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    private Reader findReaderById(Reader reader) {
        return readerRepository.findById(reader.getId()).orElseThrow();
    }

    private void deleteReader(Reader reader) {
        readerRepository.deleteById(reader.getId());
    }

}
