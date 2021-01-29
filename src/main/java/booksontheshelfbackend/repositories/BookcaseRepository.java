package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entities.Bookcase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookcaseRepository extends JpaRepository<Bookcase, Long> {


    @Override
    List<Bookcase> findAll();

    @Override
    Optional<Bookcase> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
