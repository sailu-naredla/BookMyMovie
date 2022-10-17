package com.canvas.service.impl;

import com.canvas.constants.Constants;
import com.canvas.dto.BookingRequest;
import com.canvas.dto.BookingResponse;
import com.canvas.exception.BadRequestException;
import com.canvas.exception.BookingException;
import com.canvas.model.BookingEntity;
import com.canvas.model.CustomerEntity;
import com.canvas.model.ScreeningEntity;
import com.canvas.repository.BookingRepository;
import com.canvas.repository.CustomerRepository;
import com.canvas.repository.ScreeningRepository;
import com.canvas.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        if(null != bookingRequest){
            try{
            Optional<CustomerEntity> customer = customerRepository.findById(bookingRequest.getCustomer());
            Optional<ScreeningEntity> screening = screeningRepository.findById(bookingRequest.getScreening());
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setCustomer(customer.get());
            bookingEntity.setScreening(screening.get());
            bookingEntity.setTransactionId(UUID.randomUUID().toString());
            bookingRepository.save(bookingEntity);
            return new BookingResponse(Constants.BOOKING_MESSAGE, bookingEntity.getTransactionId());
            }catch (Exception e){
                throw new BookingException(Constants.BOOKING_ERROR);
            }
        }else{
            throw  new BadRequestException(Constants.BOOKING_INVALID_INPUTS);
        }
    }
}
