package com.indianhive.web.booking.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation") // SQL tables are usually lowercase; use double quotes " "
public class Reservation {

  // 1. Booking ID: Use a specific ID field, not the Name
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID (1, 2, 3...)
  private Long id;

  // 2. Customer Info
  @Column(nullable = false) // Ensures this cannot be empty in the DB
  private String customerName;

  // 3. Date and Time: Use Java Time API, not Strings
  private LocalDate date;      // Represents just the date (e.g., 2023-10-25)
  private LocalTime startTime; // Represents start time (e.g., 19:00)
  private LocalTime endTime;   // Represents end time (e.g., 21:00)

  ;

  // 5. Essential Extra: Number of people!
  private Integer partySize;

  // --- CONSTRUCTORS, GETTERS, AND SETTERS ---
  // (You need these for JPA to work, or use the Library 'Lombok')

  public Reservation() {
  }

  public Reservation(String customerName, LocalDate date, LocalTime startTime, Integer partySize) {
    this.customerName = customerName;
    this.date = date;
    this.startTime = startTime;
    this.partySize = partySize;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public Integer getPartySize() {
    return partySize;
  }

  public void setPartySize(Integer partySize) {
    this.partySize = partySize;
  }
}