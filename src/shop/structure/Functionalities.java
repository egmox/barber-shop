package shop.structure;

import shop.constants.ConfigConstants;
import shop.constants.CustomerWaitingStatus;

public interface Functionalities {

	void addCustomer(int numberOfCustomers) throws Exception;

	CustomerWaitingStatus generateWaitingStatus(); // cannot have private abstract methods in versions before java 9

	default void updateNumberOfChairs(int numberOfChairs) {
		ConfigConstants.MAX_ALLOWED_QUEUE = numberOfChairs;
	}

}
