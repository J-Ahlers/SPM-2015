package main;

import math.Function;
import math.SimpsonsRule;
import math.TDistribution;

public class Test {

	public static void main(String[] args) {
		Function f = new TDistribution(9);
		SimpsonsRule r = new SimpsonsRule(f, 0f, 1.1f, 0.0001f);
		float x = r.compute();
		
		System.out.println("result: " + x);

	}

}
