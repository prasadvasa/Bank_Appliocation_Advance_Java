package com.bank;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class IndividualUser implements Serializable {
	Long acc;
	String action;
	Double transAmt , bal;
	Timestamp ts;
	
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public Long getAcc() {
		return acc;
	}
	public void setAcc(Long acc) {
		this.acc = acc;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Double getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(Double transAmt) {
		this.transAmt = transAmt;
	}
	public Double getBal() {
		return bal;
	}
	public void setBal(Double bal) {
		this.bal = bal;
	}
	
	

}
