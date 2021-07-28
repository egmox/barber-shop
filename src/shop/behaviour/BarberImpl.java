package shop.behaviour;

import shop.constants.BarberStatus;
import shop.constants.ConfigConstants;
import shop.structure.Barber;
import shop.structure.Customer;

public class BarberImpl implements Barber {

	private BarberStatus status;

	@Override
	public void doHairCut(Customer customer) {
		try {
			Thread.sleep(ConfigConstants.HAIRCUT_TIME); // different type of service may take different amout of time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
