package com.cg.accountdao;

import java.util.HashMap;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;

public class AccountDao implements IAccountDao {
	
	protected EntityManager em;
	public AccountDao(EntityManager em) {
		super();
		this.em = em;
	}

	

	@Override
	public String createAccount(Account account) throws AccountException {
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,account.getMobileNo());
		Account account1=tquery.getSingleResult();
		
   if(account1.getMobileNo()!=null){
	throw new AccountException("Customer with the mobile Number "+account.getMobileNo()+" already exists in the database");

}
		em.getTransaction().begin();
		em.merge(account1);
		em.getTransaction().commit();
		return null;
		
		
		// TODO Auto-generated method stub
	
	}


	@Override
	public double showBalance(String mobileNo) throws AccountException {
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,mobileNo);
		Account account=tquery.getSingleResult();
		
   if(account==null){
	throw new AccountException("Customer with the mobile Number "+mobileNo+" already exists in the database");

}
		return account.getBalance();
	}


	@Override
	public Account deposit(String mobileNo,double depositAmount) throws AccountException {
		// TODO Auto-generated method stub
		
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,mobileNo);
		Account account=tquery.getSingleResult();
		
		Double b=account.getBalance()+depositAmount;
		account.setBalance(b);
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
		
		return account;
		
		
	}
	
	@Override
	public Account withdraw(String mobileNo, double withdrawalAmount)
			throws AccountException {
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,mobileNo);
		Account account=tquery.getSingleResult();
		
		
		Double b=account.getBalance()-withdrawalAmount;
		account.setBalance(b);
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
		
		return account;
	
	}


	@Override
	public Account transactionDetails(String mobileNo) throws AccountException {
		// TODO Auto-generated method stub
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,mobileNo);
		Account account=tquery.getSingleResult();
		
		return account;
		
	}
	
	
	@Override
	public boolean fundTransfer(String sender, String receiver, double amount)
			throws AccountException {
		// TODO Auto-generated method stub
		String query="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery=em.createQuery(query,Account.class);
		tquery.setParameter(1,sender);
		Account account=tquery.getSingleResult();
		
		String query1="select e from Account e where e.mobileNo=?";
		TypedQuery<Account> tquery1=em.createQuery(query1,Account.class);
		tquery1.setParameter(1,receiver);
		Account account1=tquery1.getSingleResult();
		
		if(account!=null && account1!=null){
			em.getTransaction().begin();
		Double b=account.getBalance()-amount;
		Double b1=account1.getBalance()+amount;
		account.setBalance(b);
		account1.setBalance(b1);
		
		em.merge(account);
		em.merge(account1);
		em.getTransaction().commit();
		
		return true;
		}
		
			return false;
		
	}

}

