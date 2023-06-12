package com.dp.springboot;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeatsAvailable {
    @Column(name = "sleeper_seats")
    private int sleeper;

    @Column(name = "ac_seats")
    private int AC;

	public int getSleeper() {
		return sleeper;
	}

	public void setSleeper(int sleeper) {
		this.sleeper = sleeper;
	}

	public int getAC() {
		return AC;
	}

	public void setAC(int aC) {
		AC = aC;
	}

	public SeatsAvailable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeatsAvailable(int sleeper, int aC) {
		super();
		this.sleeper = sleeper;
		AC = aC;
	}

    
}
