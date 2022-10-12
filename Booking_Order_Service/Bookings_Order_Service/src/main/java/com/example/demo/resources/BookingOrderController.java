package com.example.demo.resources;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingOrder;
import com.example.demo.repository.BookingOrderRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class BookingOrderController {
	
	Logger logger=  LogManager.getLogger(BookingOrder.class);
	
	@Autowired
	private BookingOrderRepository bookRepository;

	@PostMapping("/addOrder")
	public String saveBook(@RequestBody BookingOrder book) {
		logger.info("saveBookingOrder method accessed");
		bookRepository.save(book);
		return "Booked ticket with trainId :  " + book.getTrainId();
    }
	@GetMapping("/{trainId}")
	public Optional<BookingOrder> getBook(@PathVariable String trainId){
		logger.info("getBookingOrder method accessed");
		return bookRepository.findById(trainId);
	}
	@PutMapping("/update/{trainId}")
	public BookingOrder updateOrder(@PathVariable("trainId") String trainId,@RequestBody BookingOrder order ) {
		logger.info("updateBookingOrder method accessed");
		order.setTrainId(trainId);
		bookRepository.save(order);
		return order;
	}
		
	 @DeleteMapping("/delete/{trainId}")
	 public String deleteOrder (@PathVariable String trainId) {
		 logger.info("deleteBookingOrder method accessed");
		 bookRepository.deleteById(trainId);
		 return "Order deleted with trainId : "+trainId;
		}
	}

