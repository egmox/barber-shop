package shop.behaviour;

import shop.constants.CustomerWaitingStatus;
import shop.structure.Customer;

public class CustomerImpl implements Customer {

	private CustomerWaitingStatus waitingStatus;
	
	public CustomerImpl(CustomerWaitingStatus waitingStatus) {
		this.waitingStatus = waitingStatus;
	}

	@Override
	public CustomerWaitingStatus getWaitingStatus() {
		return this.waitingStatus;
	}

	@Override
	public void setWaitingStatus(CustomerWaitingStatus customerWaitingStatus) {
		this.waitingStatus = customerWaitingStatus;
	}

}
