package com.cg.accountdao;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;

public interface IAccountDao {
	String createAccount(Account account) throws AccountException;
	double showBalance(String mobileNo) throws AccountException;
	Account deposit(String mobileNo,double depositAmount) throws AccountException;
	Account withdraw(String mobileNo,double withdrawalAmount) throws AccountException;
	Account transactionDetails(String mobileNo) throws AccountException;
	boolean fundTransfer(String sender,String receiver,double amount) throws AccountException;



}
