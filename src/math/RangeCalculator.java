package math;

import list.PairList;
import list.ValuePair;

public class RangeCalculator {

	public double getRange(PairList<Integer> values, int estimatedNew, double precision) {
		
		RegressionCalculator rcSize = new RegressionCalculator(values);
		double b0 = rcSize.getB0();
		double b1 = rcSize.getB1();
		
		SimpsonsRule r3 = new SimpsonsRule(new TDistribution(values.getActualCount()), null, (float) precision, 0.00001f);
		
		if(values.getActualCount() < 3)
			return 0d;

		ValuePair<Double> avg = Math.avgI(values);
		double top = (estimatedNew - avg.getX()) * (estimatedNew - avg.getX());
		double bottom = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> n = (ValuePair<Integer>) values.getNext();
			if(n.getX() == null || n.getY() == null)
				continue;
			
			bottom += (n.getX() - avg.getX()) * (n.getX() - avg.getX());
		}
		
		double t = r3.compute();
		System.out.println("t ("+precision+"): "+t);
		double range = t * java.lang.Math.sqrt(getStdDev(values, b0, b1)) * java.lang.Math.sqrt( 1 + 1 / values.getActualCount() + top / bottom );
		return range;
	}
	
	private static double getStdDev(PairList<Integer> values, double b0, double b1) {
		double sum = 0;
		int count = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> next = (ValuePair<Integer>) values.getNext();
			if(next.getX() == null || next.getX() == null)
				continue;
			double v = next.getY() - b0 - b1*next.getY();
			sum += v*v;
			count++;
		}
		return sum / (count - 2);
	}
}
