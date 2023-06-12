package com.dp.springboot;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price {
    @Column(name = "sleeper_price")
    private int sleeper;

    @Column(name = "ac_price")
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

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(int sleeper, int aC) {
		super();
		this.sleeper = sleeper;
		AC = aC;
	}

    
}
