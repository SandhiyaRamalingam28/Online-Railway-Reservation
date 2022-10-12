package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.BookingOrder;
import com.example.demo.repository.BookingOrderRepository;
import com.example.demo.service.BookingOrderService;


@SpringBootTest
@RunWith(SpringRunner.class)
class BookingsOrderServiceApplicationTests {

	@Autowired
	private BookingOrderService bookingOrderService;

	@Test
	void contextLoads() {
	}
	@MockBean
	private BookingOrderRepository bookingOrderRepository;
	

	
	@Test
	public void getOrderTest() {
		when(bookingOrderRepository.findAll()).thenReturn(Stream
				.of(new BookingOrder("5555","5","Trivandrum","Madurai"), 
	       new BookingOrder("12345","6","Chennai","Coimbatore")).collect(Collectors.toList()));
		assertEquals(2,bookingOrderService.getContact().size());
	}
	
		@Test
		public void saveOrderTest() {
			BookingOrder bookingOrder = new BookingOrder("ABCDEF","5","chn","Madurai"); 
			when(bookingOrderRepository.save(bookingOrder)).thenReturn(bookingOrder);
			assertEquals(bookingOrder, bookingOrderService.addOrder(bookingOrder));		
		}
			
		@Test
		public void deleteOrderTest() {
			BookingOrder bookingOrder = new BookingOrder("5555","5","Trivandrum","Madurai"); 
			bookingOrderService.deleteOrder(bookingOrder);
			verify(bookingOrderRepository, times(1)).delete(bookingOrder);
		}

}
