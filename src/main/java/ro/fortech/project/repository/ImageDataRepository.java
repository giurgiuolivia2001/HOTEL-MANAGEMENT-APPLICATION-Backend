package ro.fortech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fortech.project.entities.ImageData;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);
}
