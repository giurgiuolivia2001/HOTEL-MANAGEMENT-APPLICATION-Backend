package ro.fortech.project.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.fortech.project.entities.Order;
import ro.fortech.project.payload.response.MessageResponse;
import ro.fortech.project.services.OrderService;
import ro.fortech.project.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/kitchen")
@PreAuthorize("hasRole('KITCHEN')")
public class KitchenController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Operation(summary = "Mark order as done", description = "Mark order as done")
    @PutMapping("/markOrderDone/{id}")
    public ResponseEntity<MessageResponse> markOrderDone(@PathVariable Long id) {
        orderService.markOrderDone(id);
        return ResponseEntity.ok(new MessageResponse("Order is done"));
    }

    @Operation(summary = "Get all orders", description = "Get all orders")
    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return orderService.findAllOrders();
    }

    @PostMapping("/markUnavailable/{id}")
    public ResponseEntity<?> markProductUnavailable(@PathVariable Long id) {
        productService.markUnavailable(id);
        return ResponseEntity.ok(new MessageResponse("Product marked unavailable"));
    }
}


