package shop;

import java.util.LinkedList;
import java.util.Scanner;

import shop.behaviour.BarberImpl;
import shop.behaviour.CustomerImpl;
import shop.constants.BarberStatus;
import shop.constants.ConfigConstants;
import shop.constants.CustomerWaitingStatus;
import shop.constants.GenericConstants;
import shop.constants.ServiceType;
import shop.exceptions.InvalidInputException;
import shop.structure.Functionalities;

public class BarberShop implements Functionalities {

	static Scanner scan = new Scanner(System.in);
	static BarberImpl barber = new BarberImpl();
	static BarberShop shop = new BarberShop();
	public static LinkedList<CustomerImpl> customers = new LinkedList<>(); // prioritize customers

	private BarberShop() {
		ConfigConstants.loadConfig();
	}

	public static void main(String[] args) throws InvalidInputException {
		System.out.println("Enter number of waiting chairs.");
		ConfigConstants.MAX_ALLOWED_QUEUE = getInput();

		while (true) {
			System.out.println("Add number of customers.");
			int numberOfCustomers = getInput();
			System.out.println("No. customers: "+numberOfCustomers);
			if (numberOfCustomers == 0)
				break;
			shop.addCustomer(numberOfCustomers);
		}
	}

	@Override
	public void addCustomer(int numberOfCustomers) {
		CustomerImpl customer = null;
		for (int i = 0; i < numberOfCustomers; i++) {
			customer = new CustomerImpl((CustomerWaitingStatus) generateWaitingStatus(), ServiceType.HAIRCUT);
			if (!customer.getWaitingStatus().equals(CustomerWaitingStatus.NOT_COMING)) {
				customers.addLast(customer);
			}
		}
		if (barber.getStatus().equals(BarberStatus.SLEEPING)) {
			barber.startServe();
		}
		if (customers.size() < 1) {
			barber.goToSleep();
		}
	}

	@Override
	public CustomerWaitingStatus generateWaitingStatus() {
		if (customers.size() >= ConfigConstants.MAX_ALLOWED_QUEUE) {
			return CustomerWaitingStatus.NOT_COMING;
		} else
			return CustomerWaitingStatus.WAITING;
	}

	private static int getInput() throws InvalidInputException {
		String input = scan.nextLine();
		int inputNum = 0;
		if (input != null && !input.equals("")) {
			inputNum = Integer.parseInt(input);
		}
		if (inputNum < 0)
			throw new InvalidInputException(GenericConstants.INVALID_NUMBER_OF_CHAIRS);
		return inputNum;
	}
}
