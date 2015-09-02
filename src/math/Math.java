package math;

import list.List;
import list.PairList;
import list.ValuePair;

public class Math {
	
	public static final double PI = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
	public static final double E = 2.71828182845904523536028747135266249775724709369995;

	public static Float avg(List<Number> values) {
		float avg = 0;
		float sum = 0;
		float count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			Number n = values.getNext();
			if(n == null)
				continue;
			
			sum += n.floatValue();
			count++;
		}
		
		if(count == 0)
			return 0f;
		
		avg = sum / count;
		return avg;
	}
	
	public static ValuePair<Float> avg(PairList<Number> values) {
		float avgX = 0f;
		float avgY = 0f;
		Float sumX = 0f;
		Float sumY = 0f;
		int count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> next = (ValuePair<Number>) values.getNext();
			
			if(next.getX() == null || next.getX() == null)
				continue;
			
			sumX += next.getX().floatValue();
			sumY += next.getY().floatValue();
			count++;
		}
		
		if(count == 0)
			return new ValuePair<Float>(0f, 0f);
		
		avgX = (float) sumX / (float) count;
		avgY = (float) sumY / (float) count;
		return new ValuePair<Float>(avgX, avgY);
	}
	
	public static Float getSum(List<Number> values) {
		float sum = 0f;
		while(values.hasNext()) {
			Number n = values.getNext();
			if(n == null)
				continue;
			
			sum += n.floatValue();
		}
		return sum;
	}
	
	public static Float stddev(List<Number> values) {
		float stddev = 0;
		float avg = avg(values);
		int count = 0;
		
		if(values.length < 2)
			return null;
		
		while(values.hasNext()) {
			Float n = values.getNext().floatValue();
			if(n == null)
				continue;
			
			float next = n - avg;
			stddev += next * next;
			count++;
		}
		
		if(count < 2)
			return null;
		
		stddev = stddev / (values.length - 1);
		stddev = (float) java.lang.Math.sqrt(stddev);
		
		return stddev;
	}
	
	public static float gamma(float x) {
		// Additional ending criteria x < 0.5 in order to guarantee a finite function
		if(x == 1.0d || x < 0.5)
			return 1;
		else if(x == 0.5)
			return (float) java.lang.Math.sqrt(PI);
		else
			return (x - 1f) * gamma(x - 1f);
	}
}
