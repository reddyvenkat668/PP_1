package com.cg.cg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.accountservice.AccountService;
import com.cg.accountservice.IAccountService;

public class AccountTest {

	IAccountService service=new AccountService();

	@Test
	public void testGetMobileNo() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("123456789");
		account.setBalance(10000);
		account.setName("Bhanu");
		account.setEmailId("bhanu@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits", e.getMessage());
		}
		
	}

	@Test
	public void testSetMobileNo() {
	//	fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567890");
		account.setBalance(25000);
		account.setName("Pavan");
		account.setEmailId("pavan@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer with the mobile Number "+account.getMobileNo()+" already exists in the database", e.getMessage());
		}
	}

	@Test
	public void testGetName() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567890");
		account.setBalance(25000);
		account.setName("pavan");
		account.setEmailId("pavan@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer Name should start with capital letter, should contain only capital letters and should contain minimum three characters", e.getMessage());
		}
	}

	@Test
	public void testSetName() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567890");
		account.setBalance(25000);
		account.setName("An");
		account.setEmailId("pavan@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer Name should start with capital letter, should contain only capital letters and should contain minimum three characters", e.getMessage());
		}
	}

	@Test
	public void testGetEmailId() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567890");
		account.setBalance(25000);
		account.setName("Bhanu");
		account.setEmailId("Pavan@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Enter a correct Email address", e.getMessage());
		}
		
	}

	@Test
	public void testSetEmailId() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567891");
		account.setBalance(25000);
		account.setName("Bhanu");
		account.setEmailId("xyz@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer with the emailId "+account.getEmailId()+" already exists in the database", e.getMessage());
		}
	}

	@Test
	public void testSetBalance() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567891");
		account.setBalance(0);
		account.setName("Bhanu");
		account.setEmailId("bhanu@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Minimum balance should be greater than zero", e.getMessage());
		}
	}

	@Test
	public void testGetBalance() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567891");
		try {
			service.showBalance(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			assertEquals("Customer with the mobile Number "+account.getMobileNo()+" does not exists in the database", e.getMessage());
		}
		
		
	}
	
	@Test
	public void testName(){
		Account account=new Account();
		account.setMobileNo("1234567891");
		account.setBalance(25000);
		account.setName("");
		account.setEmailId("bhanu@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer Name cannot be null", e.getMessage());
		}
		
	}
	
	@Test
	public void testSetEmailId1() {
		//fail("Not yet implemented");
		Account account=new Account();
		account.setMobileNo("1234567891");
		account.setBalance(25000);
		account.setName("Bhanu");
		account.setEmailId("xyz@@gmail.com");
		try {
			service.createAccount(account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace()
			assertEquals("Enter a correct Email address", e.getMessage());
		}
	}
	
	@Test
	public void testDeposit(){
		Account account=new Account();
		account.setMobileNo("1234567895");
		try {
			service.deposit(account.getMobileNo(), 120);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer with the mobile Number "+account.getMobileNo()+" does not exists in the database",e.getMessage());
		}
	}
	
	@Test
	public void testDeposit1(){
		Account account=new Account();
		account.setMobileNo("123456");
		try {
			service.deposit(account.getMobileNo(), 120);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
	}
	
	@Test
	public void testshowBalance(){
		Account account=new Account();
		account.setMobileNo("123456");
		try {
			service.showBalance(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
	}
	@Test
	public void testshowBalance1(){
		Account account=new Account();
		account.setMobileNo("123456789");
		try {
			service.showBalance(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
	}
	
	
	@Test
	public void testForFundTransfer(){
		Account account1=new Account();
		Account account2=new Account();
		account1.setMobileNo("123456");
		account2.setMobileNo("1234567");
		try {
			service.fundTransfer(account1.getMobileNo(), account2.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
		
	}
	
	@Test
	public void testForFundTransfer1(){
		Account account1=new Account();
		Account account2=new Account();
		account1.setMobileNo("1234567890");
		account2.setMobileNo("1234567");
		try {
			service.fundTransfer(account1.getMobileNo(), account2.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
		
	}
	
	@Test
	public void testForFundTransfer2(){
		Account account1=new Account();
		Account account2=new Account();
		account1.setMobileNo("1234560");
		account2.setMobileNo("1234567890");
		try {
			service.fundTransfer(account1.getMobileNo(), account2.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
		
	}
	
	@Test
	public void testForFundTransfer3(){
		Account account1=new Account();
		Account account2=new Account();
		account1.setMobileNo("1234567890");
		account2.setMobileNo("4567891230");
		try {
			service.fundTransfer(account1.getMobileNo(), account2.getMobileNo(), 0);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Deposit Amount should be greater than zero",e.getMessage());
		}
		
	}
	
	
	@Test
	public void testForFundTransfer4(){
		Account account1=new Account();
		Account account2=new Account();
		account1.setMobileNo("1234567890");
		account2.setMobileNo("4567891230");
		try {
			service.fundTransfer(account1.getMobileNo(), account2.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
	}
	@Test
	public void testwithdraw(){
		Account account=new Account();
		account.setMobileNo("123456");
		try {
			service.withdraw(account.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
	}
	@Test
	public void testwithdraw1(){
		Account account=new Account();
		account.setMobileNo("1234567896");
		try {
			service.withdraw(account.getMobileNo(), 800000);
		} catch (AccountException e) {
			
			assertEquals("Insufficient Balance",e.getMessage());
		}
	}
	
	@Test
	public void testwithdraw2(){
		Account account=new Account();
		account.setMobileNo("1234567890");
		try {
			service.withdraw(account.getMobileNo(), 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void testTransactionDetails(){
		Account account=new Account();
		account.setMobileNo("123456789");
		try {
			service.transactionDetails(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Mobile Number Should contain ten digits",e.getMessage());
		}
	}

	@Test
	public void testTransactionDetails1(){
		Account account=new Account();
		account.setMobileNo("1234567899");
		try {
			service.transactionDetails(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			assertEquals("Customer with the mobile Number "+account.getMobileNo()+" does not exists in the database",e.getMessage());
		}
	}
	
	@Test
	public void testTransactionDetails2(){
		Account account=new Account();
		account.setMobileNo("1234567890");
		try {
			service.transactionDetails(account.getMobileNo());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
	}
}

