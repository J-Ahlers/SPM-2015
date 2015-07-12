package math;

import list.PairList;
import list.ValuePair;
import math.distributions.TDistribution;

public class RangeCalculator {

	public double getRange(PairList<Number> values, int estimatedNew, double precision) {
		
		RegressionCalculator rcSize = new RegressionCalculator(values);
		double b0 = rcSize.getB0();
		double b1 = rcSize.getB1();
		
		if(values.getActualCount() < 3)
			return 0d;

		ValuePair<Double> avg = Math.avg(values);
		double top = ((double) estimatedNew - avg.getX()) * ((double) estimatedNew - avg.getX());
		double bottom = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> n = (ValuePair<Number>) values.getNext();
			if(n.getX() == null || n.getY() == null)
				continue;
			
			double x = (double) ((Number) n.getX()).intValue();
			bottom += (x - avg.getX()) * (x - avg.getX());
		}
		
		double t = getAlpha(values.getActualCount(), precision);
		double o = java.lang.Math.sqrt(getStdDev(values, b0, b1));
//		System.out.println("t ("+precision+"): "+t);
//		System.out.println("o: "+o);
		double range = t * o * java.lang.Math.sqrt( 1d + 1d / (double) values.getActualCount() + top / bottom );
		return range;
	}
	
	private static double getStdDev(PairList<Number> values, double b0, double b1) {
		double sum = 0;
		int count = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> next = (ValuePair<Number>) values.getNext();
			if(next.getX() == null || next.getX() == null)
				continue;
			double x = (double) ((Number) next.getX()).intValue();
			double y = (double) ((Number) next.getY()).intValue();
			double v = y - b0 - b1*x;
			sum += v*v;
			count++;
		}
		return sum / ((double) count - 2);
	}
	
	private double getAlpha(int n, double precision) {
		double currentPrecision = 0.0f;
		float currentValue = 0.0f;
		while(currentPrecision < precision) {
			currentValue += 0.001f;
			SimpsonsRule r3 = new SimpsonsRule(new TDistribution(n), null, currentValue, 0.001f);
			currentPrecision = r3.compute();
			//System.out.println("CV: " + currentValue + " , CP: " + currentPrecision);
		}
		return currentValue;
	}
}
