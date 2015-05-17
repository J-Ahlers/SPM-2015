package main;

import list.List;
import list.PairList;
import list.ValuePair;
import math.Math;
import math.RegressionCalculator;
import metrics.ProjectData;
import metrics.ProjectDataManager;

public class ExerciseRegressionCalculator {

	public static void main(String[] args) {
		ProjectDataManager manager = new ProjectDataManager();
		List<ProjectData> data = manager.getExerciseData();
		
		PairList<Integer> size = new PairList<Integer>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			size.add(next.getENCLOC(), next.getANCLOC());
		}
		RegressionCalculator rcSize = new RegressionCalculator(size);
		System.out.println("Size: ß0 = " + rcSize.getB0() + " | ß1 = " + rcSize.getB1());
		
		PairList<Integer> time = new PairList<Integer>();
		List<Integer> actualTimes = new List<Integer>();
		while(data.hasNext()) {
			ProjectData next = (ProjectData) data.getNext();
			time.add(next.getEtime(), next.getAtime());
			actualTimes.add(next.getAtime());
		}
		RegressionCalculator rcTime = new RegressionCalculator(time);
		System.out.println("Time: " + rcTime.getB0() + " | ß1 = " + rcTime.getB1());
		System.out.println("Time-range: ß0 = " + getRange(time, 137, rcTime.getB0(), rcTime.getB1()));

	}
	
	private static double getRange(PairList<Integer> values, int estimatedNew, double b0, double b1) {
		if(values.getActualCount() < 3)
			return 0d;

		ValuePair<Double> avg = Math.avgI(values);
		double top = (estimatedNew - avg.getX()) * (estimatedNew - avg.getX());
		double bottom = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> n = (ValuePair<Integer>) values.getNext();
			if(n == null)
				continue;
			
			bottom += (n.getX() - avg.getX()) * (n.getX() - avg.getX());
		}
		
		double range = getAlpha(values.getActualCount()) * java.lang.Math.sqrt(getStdDev(values, b0, b1)) * java.lang.Math.sqrt( 1 + 1 / values.getActualCount() + top / bottom );
		return range;
	}
	
	private static double getStdDev(PairList<Integer> values, double b0, double b1) {
		double sum = 0;
		int count = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> next = (ValuePair<Integer>) values.getNext();
			if(next.getX() == null && next.getX() == null)
				continue;
			double v = next.getY() - b0 - b1*next.getY();
			sum += v*v;
			count++;
		}
		return sum / (count - 2);
	}
	
	private static double getAlpha(int size) {
		// After table A2 from page 489 for the t distribution
		switch(size) {
		case 1:
			return 1.963;
		case 2:
			return 1.386;
		case 3:
			return 1.25;
		case 4:
			return 1.190;
		case 5:
			return 1.156;
		case 6:
			return 1.134;
		case 7:
			return 1.119;
		case 8:
			return 1.108;
		case 9:
			return 1.1;
		case 10:
			return 1.093;
		default:
			return 0;
		}
	}

}
