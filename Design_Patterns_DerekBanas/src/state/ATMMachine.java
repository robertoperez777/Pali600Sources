package state;

import proxy.GetATMData;

public class ATMMachine implements GetATMData {

	ATMState hasCard;
	ATMState noCard;
	ATMState hasCorrectPin;
	ATMState atmOutOfMoney;

	ATMState atmState;

	int cashInMachine = 2000;
	boolean correctPinEntered = false;

	public ATMMachine() {

		this.hasCard = new HasCard(this);
		this.noCard = new NoCard(this);
		this.hasCorrectPin = new HasPin(this);
		this.atmOutOfMoney = new NoCash(this);

		this.atmState = this.noCard;

		if (this.cashInMachine < 0) {

			this.atmState = this.atmOutOfMoney;

		}

	}

	void setATMState(ATMState newATMState) {

		this.atmState = newATMState;

	}

	public void setCashInMachine(int newCashInMachine) {

		this.cashInMachine = newCashInMachine;

	}

	public void insertCard() {

		this.atmState.insertCard();

	}

	public void ejectCard() {

		this.atmState.ejectCard();

	}

	public void requestCash(int cashToWithdraw) {

		this.atmState.requestCash(cashToWithdraw);

	}

	public void insertPin(int pinEntered) {

		this.atmState.insertPin(pinEntered);

	}

	public ATMState getYesCardState() {
		return this.hasCard;
	}

	public ATMState getNoCardState() {
		return this.noCard;
	}

	public ATMState getHasPin() {
		return this.hasCorrectPin;
	}

	public ATMState getNoCashState() {
		return this.atmOutOfMoney;
	}

	@Override
	public int getCashInMachine() {
		return this.cashInMachine;
	}

	@Override
	public ATMState getATMData() {
		return this.atmState;
	}

}