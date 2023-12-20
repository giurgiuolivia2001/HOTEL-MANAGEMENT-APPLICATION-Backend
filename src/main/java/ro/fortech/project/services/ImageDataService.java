package ro.fortech.project.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.project.repository.ImageDataRepository;

import ro.fortech.project.entities.ImageData;


@Service
public class ImageDataService {
    @Autowired
    private ImageDataRepository imageDataRepository;

    @Transactional
    public ImageData getImage(Long id) {
        return imageDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }
}

