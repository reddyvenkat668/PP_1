package com.cg.account.bean;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.account.exception.AccountException;
import com.cg.accountdao.AccountDao;
import com.cg.accountdao.IAccountDao;
import com.cg.accountservice.AccountService;
import com.cg.accountservice.IAccountService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em=emf.createEntityManager();
		IAccountDao accountDao = new AccountDao(em);
		IAccountService service = new AccountService(accountDao);
		
		Account account=new Account();
		
		account.setName("Buddu1");
		account.setMobileNo("1234567891");
		account.setEmailId("asxzdecv@gmail.com");
		account.setBalance(789456);
		//account.setLocalDate(LocalDate.now());
		try {
			service.createAccount(account);
		} catch (AccountException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		
		
		
		try {
			System.out.println(service.showBalance("1234567890"));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		try {
			service.deposit("1234567890", 100);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	
	try {
		service.withdraw("1234567890", 1000);
	} catch (AccountException e) {
		// TODO Auto-generated catch block
		e.getMessage();
	}
		
		try {
			System.out.println(service.transactionDetails("1234567890"));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		try {
			System.out.println(service.fundTransfer("1234567890", "1234567891", 1000.00));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
