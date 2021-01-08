package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entitys.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
