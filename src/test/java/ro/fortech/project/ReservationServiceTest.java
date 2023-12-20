package ro.fortech.project;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.fortech.project.entities.ERoomType;
import ro.fortech.project.entities.Reservation;
import ro.fortech.project.entities.Room;
import ro.fortech.project.repository.ReservationRepository;
import ro.fortech.project.repository.RoomRepository;
import ro.fortech.project.services.ReservationService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private RoomRepository roomRepository;

    @Test
    public void testDatesOverlapNo(){
        Date startDate1 = new Date(2023,05,21);
        Date endDate1 = new Date(2023,05,25);
        Date startDate2 = new Date(2023,06,21);
        Date endDate2 = new Date(2023,06,25);
        boolean overlap = reservationService.datesOverlap(startDate1,endDate1,startDate2,endDate2);
        assertFalse(overlap, "Dates should not overlap");

    }

    @Test
    public void testDatesOverlapYes(){
        Date startDate1 = new Date(2023,05,21);
        Date endDate1 = new Date(2023,05,25);
        Date startDate2 = new Date(2023,05,19);
        Date endDate2 = new Date(2023,05,23);
        boolean overlap = reservationService.datesOverlap(startDate1,endDate1,startDate2,endDate2);
        assertTrue(overlap, "Dates should overlap");

    }

    @Test
    public void testNumberOfDays(){
        Date startDate = new Date(2023,05,21);
        Date endDate = new Date(2023,05,25);
        long days = reservationService.numberOfDays(startDate,endDate);
        assertEquals(4,days);

    }

//    @Test
//    public void testAvailableRoom(){
//        Reservation reservation = new Reservation(1L    ,new Date(2023,05,21), new Date(2023,05,24),"double");
//        when(roomRepository.findAllByRoomType(anyString())).thenReturn(Collections.singletonList(new Room(125, ERoomType.DOUBLE,155,new ArrayList<>())));
//        Room room = reservationService.availableRoom(reservation);
//        assertNotNull(room);
//    }
//
//    @Test
//    public void testAddReservation(){
//        Reservation reservation = new Reservation(1L,new Date(2023,05,21), new Date(2023,05,22),"double");
//        Room room = new Room(123,ERoomType.DOUBLE,new BigDecimal(150),new ArrayList<>());
//        when(roomRepository.save(room)).thenReturn(room);
//        when(roomRepository.findAllByRoomType(anyString())).thenReturn(Collections.singletonList(room));
//        when(reservationRepository.save(reservation)).thenReturn(reservation);
//        Reservation addedReservation = reservationService.addReservation(reservation);
//        assertNotNull(addedReservation);
//        assertEquals(150, addedReservation.getTotalPrice());
//        verify(reservationRepository, times(1)).save(addedReservation);
//
//    }

}
