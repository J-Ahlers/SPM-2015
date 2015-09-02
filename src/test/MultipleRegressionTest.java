package test;

import list.List;
import list.TriplePairList;
import math.GaussEquation;
import math.MultipleRegressionCalculator;
import math.MultipleRegressionPredictionInterval;

public class MultipleRegressionTest {

	public static void main(String[] args) {
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
		
		System.out.println("Projected hours: " + projected_hours);
		
		MultipleRegressionPredictionInterval predictionInterval = new MultipleRegressionPredictionInterval();
		float interval_90 = predictionInterval.calculate(wxy, z, solution, .95f);
		float interval_70 = predictionInterval.calculate(wxy, z, solution, .85f);
		
		System.out.println("90 % interval: " + interval_90);
		System.out.println("70 % interval: " + interval_70);
	}
	
}
