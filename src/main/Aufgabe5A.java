package main;

import math.NormalDistribution;
import math.SimpsonsRule;

public class Aufgabe5A {

	public static void main(String[] args) {
		
		NormalDistribution n = new NormalDistribution();
		
		SimpsonsRule r1 = new SimpsonsRule(n, null, 2.5f, 0.0001f);
		System.out.println("r1: "+r1.compute()); // 0.99
		
		SimpsonsRule r2 = new SimpsonsRule(n, null, 0.2f, 0.0001f);
		System.out.println("r2: "+r2.compute()); // 0.57
		
		SimpsonsRule r3 = new SimpsonsRule(n, null, -1.1f, 0.0001f);
		System.out.println("r3: "+r3.compute()); // 0.13
	}
}
