package booksontheshelfbackend.services;

import booksontheshelfbackend.entities.Reader;
import booksontheshelfbackend.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    private List<Reader> getAllReader(){
        return readerRepository.findAll();
    }
}
