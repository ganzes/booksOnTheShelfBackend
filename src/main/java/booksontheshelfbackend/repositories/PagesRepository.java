package booksontheshelfbackend.repositories;

import booksontheshelfbackend.entities.Pages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface PagesRepository extends JpaRepository<Pages, Long> {

    @Override
    List<Pages> findAll();

    @Override
    Optional<Pages> findById(Long id);

    @Override
    void deleteById(Long id);
}
