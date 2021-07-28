package shop.exceptions;

import shop.constants.GenericConstants;

public class GenericException extends Exception {
	public GenericException() {
		super(GenericConstants.GENERIC_EXCEPTION);
	}
}
