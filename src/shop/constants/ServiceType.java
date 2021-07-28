package shop.constants;

public enum ServiceType {
	HAIRCUT("hairCut");

	private String serviceType;

	ServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getValue(ServiceType serviceType) {
		return this.serviceType;
	}
}
