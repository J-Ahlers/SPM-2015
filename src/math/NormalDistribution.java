package math;

public class NormalDistribution implements Function {

	@Override
	public float calculate(float x) {
		//return -1 * java.lang.Math.pow(2.71828, -1 * x) / java.lang.Math.pow(2 * 3.14, 0.5);
		//return -1 * java.lang.Math.pow(2.71828, x * x / 2);
		float exp = (float) java.lang.Math.pow(2.71828f, (-1f / 2f) * (x * x));
		return (float) ((1f / java.lang.Math.sqrt( 2f * 3.1415926f )) * exp);
	}
}
