package math.distributions;

import math.Function;
import math.Math;

public class TDistribution  implements Function {

	private float n;
	
	protected TDistribution(){}
	
	/**
	 * 
	 * @param n number of items (values) used in the calculation
	 */
	public TDistribution(int n) {
		this.n = (float) n;
//		double top = Math.gamma( (n + 1) / 2 );
//		double bottom1 = java.lang.Math.sqrt(n * Math.PI);
//		double bottom2 =  Math.gamma(((double) n) / 2);
//		System.out.println("g(n/2): " + bottom2);
//		System.out.println("g(n + 1 / 2): " + top);
//		System.out.println("sqrt(N*pi): " + bottom1);
	}
	
	@Override
	public float calculate(float x) {
		float term1 = (float) ((Math.gamma( (n + 1) / 2f )) / ( java.lang.Math.sqrt(n * Math.PI) * Math.gamma(n / 2f)  ));
		float term2 = 1 + ((x * x) / n);
		float term3 = (float) java.lang.Math.pow( term2 , -0.5 * (n + 1d));
		float Fi = term1 * term3;
//		System.out.println("xi: " + x +" , term1: " + term2 + " , term2: " + term3 + " , F(xi): " + Fi);
		return Fi;
	}

}
