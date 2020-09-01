package com.sbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.model.Account;
import com.sbi.model.PaymentDTO;
import com.sbi.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private AccountService accServ;

	@PostMapping("/deposit")
	public ResponseEntity<String> deposit(@RequestBody PaymentDTO pDto) {
		Account ac1 = accServ.deposit(pDto);
		String status = "fail";
		if (ac1 != null) {
			status = "Success";
		}
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
