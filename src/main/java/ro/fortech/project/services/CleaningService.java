package ro.fortech.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ro.fortech.project.entities.NotificationCleaning;
import ro.fortech.project.entities.Room;
import ro.fortech.project.entities.User;
import ro.fortech.project.payload.request.IntermediateNotification;
import ro.fortech.project.repository.CleaningRepository;
import ro.fortech.project.repository.RoomRepository;
import ro.fortech.project.repository.UserRepository;

import java.util.List;

@Service
public class CleaningService {

    @Autowired
    private CleaningRepository cleaningRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;


    public NotificationCleaning addNotification(IntermediateNotification notification) {
        Room room = roomRepository.findById(notification.getRoomNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room with number " + notification.getRoomNumber() + " not found"));
        NotificationCleaning notificationCleaning = new NotificationCleaning(notification.getDetails());
        notificationCleaning.setRoom(room);
        return cleaningRepository.save(notificationCleaning);
    }

    public NotificationCleaning markInProgress(Long notificationId, Long personId) {
        NotificationCleaning notificationCleaning = cleaningRepository.findById(notificationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification with id " + notificationId + " not found"));
        User userCleaning = userRepository.findById(personId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id " + personId + " not found"));
        notificationCleaning.setCleaner(userCleaning);
        return cleaningRepository.save(notificationCleaning);
    }

    public NotificationCleaning markDoneNotification(Long notificationId) {
        NotificationCleaning notificationCleaning = cleaningRepository.findById(notificationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification with id " + notificationId + " not found"));
        notificationCleaning.setDone(true);
        return cleaningRepository.save(notificationCleaning);
    }

    public List<NotificationCleaning> getCleaningNotifications() {
        return cleaningRepository.findAll();
    }


}
