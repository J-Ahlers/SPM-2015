package main;

import list.List;
import list.TriplePairList;
import math.GaussEquation;
import math.MultipleRegressionCalculator;
import math.MultipleRegressionPredictionInterval;

public class Aufgabe10A {
	
	public static void main(String[] args) {
		System.out.println("\nTable D16\n");
		float est_loc_new = 185;
		float est_loc_reused = 150;
		float est_loc_mod = 45;
		
		TriplePairList<Number> wxy = new TriplePairList<Number>();
		wxy.add(345, 65, 23);
		wxy.add(168, 18, 18);
		wxy.add(94, 0, 0);
		wxy.add(187, 185, 98);
		wxy.add(621, 87, 10);
		wxy.add(255, 0, 0);
		
		List<Number> z = new List<Number>();
		z.add(31.4f);
		z.add(14.6f);
		z.add(6.4f);
		z.add(28.3f);
		z.add(42.1f);
		z.add(15.3f);
		
		MultipleRegressionCalculator calc = new MultipleRegressionCalculator();
		GaussEquation solution = calc.calculate(wxy, z);
		solution.setX0(1);
		solution.setX1(est_loc_new);
		solution.setX2(est_loc_reused);
		solution.setX3(est_loc_mod);
		
		float projected_hours = solution.get0() + solution.get1() + solution.get2() + solution.get3();
		
		System.out.println("b0 "+solution.getB0());
		System.out.println("b1 "+solution.getB1());
		System.out.println("b2 "+solution.getB2());
		System.out.println("b3 "+solution.getB3()+"\n");
		
		System.out.println("Projected hours: " + projected_hours);
		
		MultipleRegressionPredictionInterval predictionInterval = new MultipleRegressionPredictionInterval();
		float interval_90 = predictionInterval.calculate(wxy, z, solution, .95f);
		float interval_70 = predictionInterval.calculate(wxy, z, solution, .85f);
		
		System.out.println("70 % UPI: " + (projected_hours+interval_70));
		System.out.println("70 % LPI: " + (projected_hours-interval_70)+"\n");
		
		System.out.println("90 % UPI: " + (projected_hours+interval_90));
		System.out.println("90 % LPI: " + (projected_hours-interval_90));
		
		System.out.println("\n\n\nAppendix A\n");
		testAppendix();
	}

	private static void testAppendix() {
		float est_loc_new = 650;
		float est_loc_reused = 3000;
		float est_loc_mod = 155;
		
		TriplePairList<Number> wxy = new TriplePairList<Number>();
		wxy.add(1142, 1060, 325);
		wxy.add(863, 995, 98);
		wxy.add(1065, 3205, 23);
		wxy.add(554, 120, 0);
		wxy.add(983, 2896, 120);
		wxy.add(256, 485, 88);
		
		List<Number> z = new List<Number>();
		z.add(201);
		z.add(98);
		z.add(162);
		z.add(54);
		z.add(138);
		z.add(61);
		
		MultipleRegressionCalculator calc = new MultipleRegressionCalculator();
		GaussEquation solution = calc.calculate(wxy, z);
		solution.setX0(1);
		solution.setX1(est_loc_new);
		solution.setX2(est_loc_reused);
		solution.setX3(est_loc_mod);
		
		float projected_hours = solution.get0() + solution.get1() + solution.get2() + solution.get3();
		
		System.out.println("b0 "+solution.getB0());
		System.out.println("b1 "+solution.getB1());
		System.out.println("b2 "+solution.getB2());
		System.out.println("b3 "+solution.getB3()+"\n");
		
		System.out.println("Projected hours: " + projected_hours);
		
		MultipleRegressionPredictionInterval predictionInterval = new MultipleRegressionPredictionInterval();
		float interval_90 = predictionInterval.calculate(wxy, z, solution, .95f);
		float interval_70 = predictionInterval.calculate(wxy, z, solution, .85f);
		
		System.out.println("70 % UPI: " + (projected_hours+interval_70));
		System.out.println("70 % LPI: " + (projected_hours-interval_70)+"\n");
		
		System.out.println("90 % UPI: " + (projected_hours+interval_90));
		System.out.println("90 % LPI: " + (projected_hours-interval_90));
	}
}
