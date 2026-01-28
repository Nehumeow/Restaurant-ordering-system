package com.indianhive.web.ordering.service;

import com.indianhive.web.ordering.entity.orderEntity;
import com.indianhive.web.ordering.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class sample4 {
    private final orderRepository orderRepository;

    @Autowired
    public sample4(orderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public orderEntity createOrder(orderEntity order) {
        return orderRepository.save(order);
    }

    public Optional<orderEntity> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    // Get all orders for a user
    public List<orderEntity> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Update order
    public orderEntity updateOrder(orderEntity order) {
        return orderRepository.save(order);
    }

    public boolean deleteOrder(Long orderId){
        if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    // Update order status
    public orderEntity updateOrderStatus(Long orderId, String newStatus) {
        Optional<orderEntity> orderOpt = orderRepository.findById(orderId);

        if (orderOpt.isPresent()) {
            orderEntity order = orderOpt.get();
            order.setStatus(newStatus);
            return orderRepository.save(order);
        }
        return null;
    }
}
