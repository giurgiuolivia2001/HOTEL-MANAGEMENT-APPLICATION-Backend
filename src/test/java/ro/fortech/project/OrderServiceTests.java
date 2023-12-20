package ro.fortech.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ro.fortech.project.repository.OrderRepository;
import ro.fortech.project.repository.RoomRepository;
import ro.fortech.project.services.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private RoomRepository roomRepository;

}
