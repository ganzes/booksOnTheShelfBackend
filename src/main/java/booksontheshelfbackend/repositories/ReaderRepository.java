package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long id);

    @Override
    void deleteById(Long id);
}
