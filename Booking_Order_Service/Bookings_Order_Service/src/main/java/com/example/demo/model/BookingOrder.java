package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@AllArgsConstructor
@Document(collection="Orders")
public class BookingOrder {
	@Id
	private String trainId;
	private String Passengers;
	private String source;
	private String destination;
	
	public BookingOrder() {
		
	}

	public BookingOrder(String trainId, String passengers, String source, String destination) {
		super();
		this.trainId = trainId;
		Passengers = passengers;
		this.source = source;
		this.destination = destination;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getPassengers() {
		return Passengers;
	}

	public void setPassengers(String passengers) {
		Passengers = passengers;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "BookingOrder [trainId=" + trainId + ", Passengers=" + Passengers + ", source=" + source
				+ ", destination=" + destination + "]";
	}
	
	
	

}
