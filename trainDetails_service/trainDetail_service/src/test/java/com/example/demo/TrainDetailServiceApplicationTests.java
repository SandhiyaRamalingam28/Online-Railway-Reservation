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
class TrainDetailServiceApplicationTests {

	@Autowired
	private TrainService trainService;
	
	@MockBean
	private TrainRepository trainRepository;

	@Test
	public void getTrainTest() {
		when(trainRepository.findAll()).thenReturn(Stream
				.of(new Train("101SK","ARSHI Express","Kapal","Gujar","9:00 PM","9:25 PM"), new Train("732FE","PAKIS Express","Malak","Katok","9:45 PM","10:00 PM")).collect(Collectors.toList()));		assertEquals(2,trainService.getContact().size());
	}
		@Test
		public void saveTrainTest() {
			Train train = new Train("101SK","ARSHI Express","Kapal","Gujar","9:00 PM","9:25 PM");
			when(trainRepository.save(train)).thenReturn(train);
			assertEquals(train, trainService.addTrain(train));
		
		}
		@Test
		public void deleteUserTest() {
			Train train = new Train("732FE","PAKIS Express","Malak","Katok","9:45 PM","10:00 PM");
			trainService.deleteTrain(train);
			verify(trainRepository, times(1)).delete(train);
		}


}
