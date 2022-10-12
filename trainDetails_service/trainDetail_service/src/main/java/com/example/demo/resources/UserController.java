package com.example.demo.resources;

import org.apache.logging.log4j.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/search")
public class UserController {
	
	Logger logger=  LogManager.getLogger(UserController.class);
	
	@Autowired
	private TrainRepository trainRepository;

    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
    	logger.info("getTrains method accessed to findAll trains");
    	return trainRepository.findAll();

}
    @GetMapping("/findAllTrains/{trainid}")
    public Optional<Train> getTrains(@PathVariable String trainid){
    	logger.info("getTrains method accessed using trainId");
    	return trainRepository.findById(trainid);
}
}