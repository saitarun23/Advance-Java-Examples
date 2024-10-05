package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import lombok.Data;

@Entity
//@Data
public class Account {

	@Id
	private int accno;
	private String name;
	private float amount;
	@Column(unique = true)
	private String emailid;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", amount=" + amount + ", emailid=" + emailid + "]";
	}
}
