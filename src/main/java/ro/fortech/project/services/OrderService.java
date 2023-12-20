package ro.fortech.project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ro.fortech.project.entities.Order;
import ro.fortech.project.entities.Product;
import ro.fortech.project.payload.request.AddOrderRequest;
import ro.fortech.project.payload.request.AddOrderedProductRequest;
import ro.fortech.project.repository.OrderRepository;
import ro.fortech.project.repository.ProductRepository;
import ro.fortech.project.repository.RoomRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, RoomRepository roomRepository) {
        this.orderRepository = orderRepository;
        this.roomRepository = roomRepository;
    }

    public Order addOrder(AddOrderRequest addOrderRequest) {
        roomRepository.findById(addOrderRequest.getRoomNumber())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room with number " + addOrderRequest.getRoomNumber() + " not found"));
        Order order = new Order(addOrderRequest.getRoomNumber());
        for (AddOrderedProductRequest op : addOrderRequest.getProductList()) {
            Product product = productRepository.findById(op.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + op.getId() + " not found"));
            order.addItem(product, op.getQuantity());
        }
        orderRepository.save(order);
        return order;
    }

    public Order markOrderDone(Long id) {
        Order foundOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id " + id + " not found"));
        foundOrder.setDone(true);
        orderRepository.save(foundOrder);
        return foundOrder;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }


}
