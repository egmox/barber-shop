package shop.structure;

import java.util.LinkedList;

import shop.behaviour.CustomerImpl;
import shop.constants.BarberStatus;

public interface Barber {
//	private int barberId; // in case new barbers joins the shop
//	private int clientId; // in case we need to associate specific clientID to barber

	default void startHairCut(LinkedList<CustomerImpl> customers) {
		Customer customer;
		while (customers.size() > 0) {
			customer = customers.getFirst();
			customers.removeFirst();
			doHairCut(customer);
		}
	}

	public void doHairCut(Customer customer);

	public BarberStatus getStatus();

	public void setStatus(BarberStatus status);

	public void goToSleep();

}
