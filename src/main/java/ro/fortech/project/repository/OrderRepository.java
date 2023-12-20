package ro.fortech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fortech.project.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
