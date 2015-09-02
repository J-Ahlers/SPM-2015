package test;

import math.GaussCalculator;
import math.GaussEquation;

public class GaussTest {

	public static void main(String[] args) {
		
		GaussEquation a = new GaussEquation(6f, 4863f, 8761f, 654f, 714f);
		GaussEquation b = new GaussEquation(4863f, 4521899f, 8519938f, 620707f, 667832f);
		GaussEquation c = new GaussEquation(8761f, 8519938f, 21022091f, 905925f, 1265493f);
		GaussEquation d = new GaussEquation(654f, 620707f, 905925f, 137902f, 100583f);
		
		GaussCalculator calc = new GaussCalculator();
		GaussEquation eq = calc.solve(a, b, c, d);
		System.out.println("Results:\n");
		System.out.println("b0 = " + eq.getB0());
		System.out.println("b1 = " + eq.getB1());
		System.out.println("b2 = " + eq.getB2());
		System.out.println("b3 = " + eq.getB3());
	}

}
