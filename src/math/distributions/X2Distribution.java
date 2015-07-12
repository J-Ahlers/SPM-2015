package math.distributions;

import math.Function;
import math.Math;

public class X2Distribution implements Function {

	private float n;
	
	protected X2Distribution(){}

	public X2Distribution(int n) {
		this.n = (float) n;
	}
		
	@Override
	public float calculate(float x) {
		float term1 = (float) (java.lang.Math.pow(2, n / 2f) * Math.gamma(n / 2f));
		float term2 = (float) java.lang.Math.pow(x, (n / 2f) - 1f);
		float term3 = (float) java.lang.Math.pow(Math.E, (x / -2f));
		//System.out.println("xi: " + formatNumber(x)+ " | " + formatNumber(term2) + " | " + formatNumber(term3) + " | " + formatNumber((1f / term1) * term2 * term3));
		return (1f / term1) * term2 * term3;
	}	
}
