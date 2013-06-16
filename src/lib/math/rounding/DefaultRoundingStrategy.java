package lib.math.rounding;

public class DefaultRoundingStrategy implements IRoundingStrategy {

	@Override
	public double round(double val) {
		return Math.round(val);
	}

}
