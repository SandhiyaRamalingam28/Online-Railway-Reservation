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

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

@SpringBootTest
@RunWith(SpringRunner.class)
class TrainSearchMicroservicesApplicationTests {

	@Autowired
	private TrainService trainService;
	
	@MockBean
	private TrainRepository trainRepository;
	

	@Test
	void contextLoads() {
	}
	@Test
	public void getTrainTest() {
		when(trainRepository.findAll()).thenReturn(Stream
				.of(new Train("345BF","LAKE Express","Kolkai","Peshwar","6:00 PM","6:30 PM"), 
	       new Train("732EFE","PAKIS Express","Malak","Kotak","9:45 PM","10:00 PM")).collect(Collectors.toList()));
		assertEquals(2,trainService.getContact().size());
	}

}
