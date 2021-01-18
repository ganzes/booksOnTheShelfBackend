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

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader createReader(Reader reader) {
        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (!optionalReader.isPresent()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    public Reader updateReader(Reader reader) {
        Optional<Reader> optionalReader = readerRepository.findById(reader.getId());
        if (optionalReader.isPresent()) {
            return readerRepository.save(reader);
        }
        return reader;
    }

    public Reader findReaderById(Long id) {
        return readerRepository.findById(id).orElseThrow();
    }

    public void deleteReader(Long id) {
        Reader deleteReader = readerRepository.findById(id).orElseThrow();
        readerRepository.delete(deleteReader);
    }

}
