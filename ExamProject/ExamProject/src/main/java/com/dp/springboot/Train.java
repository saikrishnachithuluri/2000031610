package com.dp.springboot;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "train_number")
    private String trainNumber;

    @Embedded
    private DepartureTime departureTime;

    @Embedded
    private SeatsAvailable seatsAvailable;

    @Embedded
    private Price price;

    @Column(name = "delayed_by")
    private int delayedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DepartureTime departureTime) {
		this.departureTime = departureTime;
	}

	public SeatsAvailable getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(SeatsAvailable seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public int getDelayedBy() {
		return delayedBy;
	}

	public void setDelayedBy(int delayedBy) {
		this.delayedBy = delayedBy;
	}

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Train(Long id, String trainName, String trainNumber, DepartureTime departureTime,
			SeatsAvailable seatsAvailable, Price price, int delayedBy) {
		super();
		this.id = id;
		this.trainName = trainName;
		this.trainNumber = trainNumber;
		this.departureTime = departureTime;
		this.seatsAvailable = seatsAvailable;
		this.price = price;
		this.delayedBy = delayedBy;
	}

    
}

