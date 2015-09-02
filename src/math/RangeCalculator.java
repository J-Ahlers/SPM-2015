package math;

import list.PairList;
import list.ValuePair;
import math.distributions.TDistribution;

public class RangeCalculator {

	public float getRange(PairList<Number> values, int estimatedNew, float precision) {
		
		RegressionCalculator rcSize = new RegressionCalculator(values);
		float b0 = rcSize.getB0();
		float b1 = rcSize.getB1();
		
		if(values.getActualCount() < 3)
			return 0f;

		ValuePair<Float> avg = Math.avg(values);
		float top = ((float) estimatedNew - avg.getX()) * ((float) estimatedNew - avg.getX());
		float bottom = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> n = (ValuePair<Number>) values.getNext();
			if(n.getX() == null || n.getY() == null)
				continue;
			
			float x = n.getX().floatValue();
			bottom += (x - avg.getX()) * (x - avg.getX());
		}
		
		float t = getAlpha(values.getActualCount(), precision);
		float o = (float) java.lang.Math.sqrt(getStdDev(values, b0, b1));
//		System.out.println("t ("+precision+"): "+t);
//		System.out.println("o: "+o);
		float range = (float) (t * o * java.lang.Math.sqrt( 1f + 1f / (float) values.getActualCount() + top / bottom ));
		return range;
	}
	
	private static float getStdDev(PairList<Number> values, float b0, float b1) {
		float sum = 0;
		int count = 0;
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> next = (ValuePair<Number>) values.getNext();
			if(next.getX() == null || next.getX() == null)
				continue;
			float x = next.getX().floatValue();
			float y = next.getY().floatValue();
			float v = y - b0 - b1*x;
			sum += v*v;
			count++;
		}
		return sum / ((float) count - 2);
	}
	
	public static float getAlpha(int n, float precision) {
		float currentPrecision = 0.0f;
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
