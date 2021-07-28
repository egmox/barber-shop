package shop.structure;

import shop.constants.CustomerWaitingStatus;
import shop.constants.ServiceType;

public interface Customer {
//	int customerId; // ID can be used to identify each customer
//	ServiceType serviceType; // ServiceType can be defined to determine how much time it will take

	CustomerWaitingStatus getWaitingStatus();

	void setWaitingStatus(CustomerWaitingStatus customerWaitingStatus);

	ServiceType getServiceType();

	void setServiceType(ServiceType serviceType);

}
