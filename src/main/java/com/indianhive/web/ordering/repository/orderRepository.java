package com.indianhive.web.ordering.repository;

import com.indianhive.web.ordering.entity.orderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface orderRepository extends JpaRepository<orderEntity, Long>  {

    // Find orders by user ID
    List<orderEntity> findByUserId(Long userId);

    // Find orders by status
    List<orderEntity> findByStatus(String status);

    // Find orders by user ID and status
    List<orderEntity> findByUserIdAndStatus(Long userId, String status);

    // Find orders by location
    List<orderEntity> findByLocation(String location);

    // Find orders by delivery date
    List<orderEntity> findByDeliveryDate(LocalDate deliveryDate);

    // Find orders by delivery date range
    List<orderEntity> findByDeliveryDateBetween(LocalDate startDate, LocalDate endDate);

    // Find orders by payment status
    List<orderEntity> findByPaymentStatus(String paymentStatus);

    // Find orders by user ID and payment status
    List<orderEntity> findByUserIdAndPaymentStatus(Long userId, String paymentStatus);

    // Find orders placed within a date range
    List<orderEntity> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Find orders by user ID ordered by order date descending
    List<orderEntity> findByUserIdOrderByOrderDateDesc(Long userId);

    @Query("SELECT o FROM orderEntity o WHERE o.userId = :userId AND o.status = 'PENDING'")
    List<orderEntity> findPendingOrdersByUser(@Param("userId") Long userId);

    // Custom query to find orders by multiple statuses
    @Query("SELECT o FROM orderEntity o WHERE o.status IN :statuses")
    List<orderEntity> findByStatusIn(@Param("statuses") List<String> statuses);

    // Count orders by user ID
    Long countByUserId(Long userId);

}
