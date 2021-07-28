package shop.exceptions;

import shop.constants.GenericConstants;

public class BarberNotFoundException extends Exception {
	public BarberNotFoundException() {
		super(GenericConstants.NO_BARBER_EXCEPTION);
	}
}
