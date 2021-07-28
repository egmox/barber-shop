package shop.constants;

import java.util.HashMap;

public class ConfigConstants {
	public static final int NUMBER_OF_BARBERS = 1; // not in use
	public static int MAX_ALLOWED_QUEUE = 10;

	public static final HashMap<ServiceType, Integer> SERVICE_DURATIONS = new HashMap<>();

	public static void loadConfig() {
		loadDurations();
//		loadPrices();
	}

	private static void loadDurations() {
		SERVICE_DURATIONS.put(ServiceType.HAIRCUT, 1000);
	}

}
