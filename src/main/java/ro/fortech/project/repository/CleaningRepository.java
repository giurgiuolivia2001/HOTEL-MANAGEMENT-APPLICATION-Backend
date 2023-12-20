package ro.fortech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.project.entities.NotificationCleaning;

@Repository
public interface CleaningRepository extends JpaRepository<NotificationCleaning, Long> {
}
