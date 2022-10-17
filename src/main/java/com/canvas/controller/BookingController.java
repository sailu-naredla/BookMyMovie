package com.canvas.controller;

import com.canvas.dto.BookingRequest;
import com.canvas.dto.BookingResponse;
import com.canvas.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/api/v1/booking")
@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody BookingRequest bookingRequest) {
        BookingResponse bookingResponse = bookingService.createBooking(bookingRequest);
        ResponseEntity<Object> response =  new ResponseEntity<>(bookingResponse, HttpStatus.OK);
        return response;
    }
}
