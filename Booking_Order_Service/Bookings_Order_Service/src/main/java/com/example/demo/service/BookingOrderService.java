package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingOrder;
import com.example.demo.repository.BookingOrderRepository;

@Service
public class BookingOrderService {
	@Autowired
	private  BookingOrderRepository bookingOrderRepository;
		

		public BookingOrder addOrder( BookingOrder bookingOrder) {
			return bookingOrderRepository.save(bookingOrder);
		}

		public List<BookingOrder> getContact() {
			List<BookingOrder> bookingOrder  = bookingOrderRepository.findAll();
			System.out.println("Getting data from DB : " + bookingOrder);
			return bookingOrder;
		}
		
		public void deleteOrder(BookingOrder bookingOrder) {
			bookingOrderRepository.delete(bookingOrder);
		}


}
