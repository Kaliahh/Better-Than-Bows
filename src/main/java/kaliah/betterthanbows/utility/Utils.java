package kaliah.betterthanbows.utility;

public class Utils {
	public static float map(float value, float fromMin, float fromMax, float toMin, float toMax) {
		float fromRange = fromMax - fromMin;
		float toRange = toMax - toMin;

		return (((value - fromMin) * toRange) / fromRange) + toMin;
	}

	public static float mapPercentage(float value, float toMin, float toMax) {
		return map(value, 0, 1, toMin, toMax);
	}
}
