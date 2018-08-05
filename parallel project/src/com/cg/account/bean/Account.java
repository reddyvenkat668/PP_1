package com.cg.account.bean;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String mobileNo;
    private	String name;
	private String emailId;
	private double balance;
	private LocalDate localDate;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", mobileNo=" + mobileNo + ", name="
				+ name + ", emailId=" + emailId + ", balance=" + balance
				+ ", localDate=" + localDate + "]";
	}
	public Account(String mobileNo, String name, String emailId,
			double balance, LocalDate string) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.emailId = emailId;
		this.balance = balance;
		this.localDate = string;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
}

