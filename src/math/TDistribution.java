package math;

public class TDistribution  implements Function {

	private int n;
	
	@SuppressWarnings("unused")
	private TDistribution(){}
	
	public TDistribution(int n) {
		this.n = n;
	}
	
	@Override
	public float calculate(float x) {
		float term1 = (float) ((Math.gamma( (n + 1) / 2 )) / ( java.lang.Math.sqrt(n * 3.14) * (n / 2)  ));
		float term2 = (float) java.lang.Math.pow( 1 + ((x * x) / n), -0.5 * (n + 1));
		return term1 * term2;
	}

}
