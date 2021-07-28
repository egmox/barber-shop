package shop.behaviour;

import shop.constants.CustomerWaitingStatus;
import shop.constants.ServiceType;
import shop.structure.Customer;

public class CustomerImpl implements Customer {

	private CustomerWaitingStatus waitingStatus;
	private ServiceType serviceType;

	public CustomerImpl(CustomerWaitingStatus waitingStatus, ServiceType serviceType) {
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

	@Override
	public ServiceType getServiceType() {
		return this.serviceType;
	}

	@Override
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

}
