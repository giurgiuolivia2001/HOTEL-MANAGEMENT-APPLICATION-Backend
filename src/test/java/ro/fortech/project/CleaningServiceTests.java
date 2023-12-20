package ro.fortech.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.fortech.project.entities.NotificationCleaning;
import ro.fortech.project.entities.Room;
import ro.fortech.project.entities.User;
import ro.fortech.project.payload.request.IntermediateNotification;
import ro.fortech.project.repository.CleaningRepository;
import ro.fortech.project.repository.RoomRepository;
import ro.fortech.project.repository.UserRepository;
import ro.fortech.project.services.CleaningService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CleaningServiceTests {

    @InjectMocks
    private CleaningService cleaningService;

    @Mock
    private CleaningRepository cleaningRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoomRepository roomRepository;

   //@Test
//    public void addNotificationTest(){
//        Long roomNumber = 101L;
//        IntermediateNotification notification = new IntermediateNotification();
//        notification.setDetails("Clean the room");
//        Room room = new Room();
//        room.setNumber(roomNumber);
//        NotificationCleaning notificationCleaning = new NotificationCleaning(notification.getDetails(),room);
//        when(roomRepository.findById(roomNumber)).thenReturn(Optional.of(room));
//        when(cleaningRepository.save(notificationCleaning)).thenReturn(notificationCleaning);
//        NotificationCleaning resultNotification = cleaningService.addNotification(notification);
//        verify(roomRepository, times(1)).findById(roomNumber);
//        verify(cleaningRepository, times(1)).save(notificationCleaning);
//        assertFalse(resultNotification.isDone());
//        assertEquals(roomNumber, resultNotification.getRoom().getNumber());
//        assertEquals("not assigned", resultNotification.getCleaner());
//    }
//
    @Test
    public void markInProgressTest(){
        Long notificationId = 1L;
        Long personId = 101L;
        NotificationCleaning notificationCleaning = new NotificationCleaning();
        notificationCleaning.setId(notificationId);
        User userCleaning = new User();
        userCleaning.setId((long) personId);
        userCleaning.setFirstName("John");
        userCleaning.setLastName("Doe");
        when(cleaningRepository.findById(notificationId)).thenReturn(Optional.of(notificationCleaning));
        when(userRepository.findById((long) personId)).thenReturn(Optional.of(userCleaning));
        when(cleaningRepository.save(notificationCleaning)).thenReturn(notificationCleaning);
        NotificationCleaning resultNotification = cleaningService.markInProgress(notificationId, personId);
        verify(cleaningRepository, times(1)).findById(notificationId);
        verify(userRepository, times(1)).findById((long) personId);
        verify(cleaningRepository, times(1)).save(notificationCleaning);
        String cleanerName = resultNotification.getCleaner().getFirstName() + " " + resultNotification.getCleaner().getLastName();
        assertEquals("John Doe", cleanerName);

    }

    @Test
    public void markDoneTest(){
        Long notificationId = 1L;
        NotificationCleaning notificationCleaning = new NotificationCleaning();
        notificationCleaning.setId(notificationId);
        notificationCleaning.setDone(false);
        when(cleaningRepository.findById(notificationId)).thenReturn(Optional.of(notificationCleaning));
        when(cleaningRepository.save(notificationCleaning)).thenReturn(notificationCleaning);
        NotificationCleaning resultNotification = cleaningService.markDoneNotification(notificationId);
        verify(cleaningRepository, times(1)).findById(notificationId);
        verify(cleaningRepository, times(1)).save(notificationCleaning);
        assertTrue(resultNotification.isDone());
    }

   @Test
    public void testGetCleaningNotifications(){
        NotificationCleaning notification1 = new NotificationCleaning();
        NotificationCleaning notification2 = new NotificationCleaning();
        List<NotificationCleaning> notifications = Arrays.asList(notification1, notification2);
        when(cleaningRepository.findAll()).thenReturn(notifications);
        List<NotificationCleaning> resultNotifications = cleaningService.getCleaningNotifications();
        verify(cleaningRepository, times(1)).findAll();
        assertEquals(2, resultNotifications.size());
        assertTrue(resultNotifications.contains(notification1));
        assertTrue(resultNotifications.contains(notification2));
    }


}