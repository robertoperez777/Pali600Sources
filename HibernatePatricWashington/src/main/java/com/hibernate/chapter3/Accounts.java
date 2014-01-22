package com.hibernate.chapter3;

import javax.persistence.Id;

public class Accounts {

	CompoundKey compoundKey;
	private int accountBalance;

	@Id
	public CompoundKey getCompoundKey() {
		return this.compoundKey;
	}

	public void setCompoundKey(CompoundKey compoundKey) {
		this.compoundKey = compoundKey;
	}

	public int getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
}
