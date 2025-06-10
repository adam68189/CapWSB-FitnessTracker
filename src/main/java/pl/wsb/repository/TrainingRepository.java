package pl.wsb.repository;

import pl.wsb.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByUserId(Long userId);
    List<Training> findByDateBefore(LocalDate date);
    List<Training> findByActivityIgnoreCase(String activity);
    List<Training> findByDateAfter(LocalDate date);
}
