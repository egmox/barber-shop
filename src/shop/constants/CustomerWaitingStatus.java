package shop.constants;

public enum CustomerWaitingStatus {
	WAITING("waiting"), HAIRCUT("haircut"), NOT_COMING("notComing");

	String key;

	CustomerWaitingStatus(String key) {
		this.key = key;
	}

	CustomerWaitingStatus() {
	}

	static CustomerWaitingStatus getValue(String str) {
		if ("waiting".equals(str))
			return WAITING;
		if ("haircut".equals(str))
			return HAIRCUT;
		if ("notComing".equals(str))
			return NOT_COMING;
		else
			throw new IllegalArgumentException();
	}
}
