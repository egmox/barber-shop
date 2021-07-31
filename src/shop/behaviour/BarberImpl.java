package shop.behaviour;

import shop.constants.BarberStatus;
import shop.constants.ConfigConstants;
import shop.structure.Barber;
import shop.structure.Customer;

public class BarberImpl implements Barber {

	private BarberStatus status;

	@Override
	public void doServe(Customer customer) {
		try {
			Thread.sleep(ConfigConstants.SERVICE_DURATIONS.get(customer.getServiceType())); // different type of service
																							// may take different amout
																							// of time
			System.out.println("1 customer served.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public BarberImpl() {
		this.status = BarberStatus.SLEEPING;
	}

	
	@Override
	public BarberStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(BarberStatus status) {
		this.status = status;
	}

	@Override
	public void goToSleep() {
		setStatus(BarberStatus.SLEEPING);
	}

}
