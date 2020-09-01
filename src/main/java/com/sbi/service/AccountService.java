package com.sbi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.model.Account;
import com.sbi.model.PaymentDTO;
import com.sbi.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	public Account deposit(PaymentDTO pDto) {
		Account account = new Account();
		account.setAccountNo(pDto.getCustId());
		account.setAccountHolderName(pDto.getCustName());
		account.setAccountBalance(pDto.getPayAmount());
		return accRepo.save(account);
	}
	
}
