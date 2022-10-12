package com.example.demo.resources;

import org.apache.logging.log4j.*;
import java.util.Optional;

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

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/trains")

public class TrainController {
	
	Logger logger=  LogManager.getLogger(TrainController.class);
	
	@Autowired
	private TrainRepository trainRepository;
	
	@PostMapping("/addTrain")
	public String saveTrain(@RequestBody Train trainId) {
		logger.info("saveTrain method accessed");
		trainRepository.save(trainId);
		return "Added train with id: "+trainId.getTrainId();
	}
	
	@GetMapping("{trainId}")
	public Optional<Train> getTrain(@PathVariable String trainId){
		logger.info("getTrain method accessed");
		return trainRepository.findById(trainId);
	}
	
	@DeleteMapping("/delete/{trainId}")
	public String deleteTrash(@PathVariable String trainId) {
		logger.info("deleteTrain method accessed");
		trainRepository.deleteById(trainId);
		return "Train deleted with id : "+trainId;
	}
	
	@PutMapping("/update/{trainId}")
	public Train updateTrain(@PathVariable ("trainId")String trainId, @RequestBody Train t) {
		t.setTrainId(trainId);
		trainRepository.save(t);
		logger.info("updateTrain method accessed");
		return t;
	}
	@PutMapping("/update")
    public Train updateTrain(@RequestBody Train t) {
        return trainRepository.save(t);
    }

}
