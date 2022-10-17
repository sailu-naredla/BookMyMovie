package com.canvas.service;

import com.canvas.dto.BookingRequest;
import com.canvas.dto.BookingResponse;

public interface BookingService {
    public BookingResponse createBooking(BookingRequest bookingRequest);
}
