package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@Service
public class TrainService {
	
	@Autowired
	private TrainRepository trainRepository;
	
/*	public Train addTrain (Train train) {
		return trainRepository.save(train);
	}*/

	public List<Train> getContact() {
		List<Train> train = trainRepository.findAll();
		System.out.println("Getting data from DB : " + train);
		return train;
	}

	public Optional<Train> getTrainbyId(String id) {
		return trainRepository.findById(id);
	}

/*	public void deleteTrain(Train train) {
		trainRepository.delete(train);
	}*/
}
