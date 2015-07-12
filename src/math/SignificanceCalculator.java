package math;

import list.PairList;
import math.distributions.TDistribution;

public class SignificanceCalculator {
	
	private CorrelationCalculator correlation;
	
	public SignificanceCalculator() {
		correlation = new CorrelationCalculator();
	}
	
	public double getSignificance(PairList<Number> values) {
		if(values.getActualCount() < 2)
			return 0;
		
		double c = correlation.getCorrelation(values);
		
		double top1 = java.lang.Math.abs(c);
		double top2 = java.lang.Math.sqrt(values.getActualCount() - 2);
		double bottom = java.lang.Math.sqrt(1 - (c * c));
		
		double t = (top1 * top2) / bottom;
		System.out.println("t: "+t);
		
		TDistribution tDistribution = new TDistribution(values.getActualCount() - 2);
		SimpsonsRule sr = new SimpsonsRule(tDistribution, null, (float) t, 0.000001f);
		
		return 2 * (1 - sr.compute());
	}
}
