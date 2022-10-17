package com.canvas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "screening")
    private ScreeningEntity screening;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "status")
    private boolean status;
}
