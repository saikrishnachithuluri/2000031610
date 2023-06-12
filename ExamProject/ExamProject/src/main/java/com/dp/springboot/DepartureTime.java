package com.dp.springboot;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DepartureTime {
    @Column(name = "departure_hours")
    private int hours;

    @Column(name = "departure_minutes")
    private int minutes;

    @Column(name = "departure_seconds")
    private int seconds;

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public DepartureTime(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public DepartureTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}
