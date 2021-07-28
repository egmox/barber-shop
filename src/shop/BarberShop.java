package shop;

import java.util.LinkedList;

import shop.behaviour.BarberImpl;
import shop.behaviour.CustomerImpl;
import shop.constants.BarberStatus;
import shop.constants.ConfigConstants;
import shop.constants.CustomerWaitingStatus;
import shop.structure.Functionalities;

public class BarberShop implements Functionalities {

	static BarberImpl barber = new BarberImpl();
	static BarberShop shop = new BarberShop();
	static LinkedList<CustomerImpl> customers = new LinkedList<>(); // automatically prioritize customers

	private BarberShop() {
	}

	public static void main(String[] args) {
		shop.startDayOfWork();
	}

	@Override
	public void startDayOfWork() {
		if (customers.size() < 1) {
			barber.goToSleep();
			return;
		}
		if (barber.getStatus().equals(BarberStatus.SLEEPING)) {
			barber.startHairCut(customers);
		}
	}

	@Override
	public void addCustomer() {
		CustomerImpl customer = new CustomerImpl((CustomerWaitingStatus) generateWaitingStatus());
		if (!customer.getWaitingStatus().equals(CustomerWaitingStatus.NOT_COMING)) {
			customers.addLast(customer);
		}
		if (barber.getStatus().equals(BarberStatus.SLEEPING)) {
			barber.startHairCut(customers);
		}
	}

	@Override
	public CustomerWaitingStatus generateWaitingStatus() {
		if (customers.size() >= ConfigConstants.MAX_ALLOWED_QUEUE) {
			return CustomerWaitingStatus.NOT_COMING;
		} else
			return CustomerWaitingStatus.WAITING;
	}

}
