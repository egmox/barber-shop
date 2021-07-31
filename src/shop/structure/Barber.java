package shop.structure;

import shop.BarberShop;
import shop.constants.BarberStatus;

public interface Barber {
//	private int barberId; // in case new barbers joins the shop
//	private int clientId; // in case we need to associate specific clientID to barber

	default void startServe() {
		while (BarberShop.customers.size() > 0) {
			doServe(getNextCustomer());
		}
	}

	default Customer getNextCustomer() {
		return BarberShop.customers.pollFirst(); // different method for dynamically prioritize customers
	}

	public void doServe(Customer customer);

	public BarberStatus getStatus();

	public void setStatus(BarberStatus status);

	public void goToSleep();

}
