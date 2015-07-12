package math;

import list.List;
import list.PairList;
import list.ValuePair;

public class Math {
	
	public static final double PI = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
	public static final double E = 2.71828182845904523536028747135266249775724709369995;

	public static Double avg(List<Number> values) {
		double avg = 0;
		double sum = 0;
		double count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			Number n = values.getNext();
			if(n == null)
				continue;
			
			sum += n.doubleValue();
			count++;
		}
		
		if(count == 0)
			return 0d;
		
		avg = sum / count;
		return avg;
	}
	
	public static ValuePair<Double> avg(PairList<Number> values) {
		double avgX = 0;
		double avgY = 0;
		Double sumX = 0d;
		Double sumY = 0d;
		int count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> next = (ValuePair<Number>) values.getNext();
			
			if(next.getX() == null || next.getX() == null)
				continue;
			
			sumX += (double) ((Number) next.getX()).intValue();
			sumY += (double) ((Number) next.getY()).intValue();
			count++;
		}
		
		if(count == 0)
			return new ValuePair<Double>(0d, 0d);
		
		avgX = (double) sumX / (double) count;
		avgY = (double) sumY / (double) count;
		return new ValuePair<Double>(avgX, avgY);
	}
	
	public static int getSum(List<Integer> values) {
		int sum = 0;
		while(values.hasNext()) {
			Integer n = (Integer) values.getNext();
			if(n == null)
				continue;
			
			sum += n;
		}
		return sum;
	}
	
	public static Double stddev(List<Number> values) {
		double stddev = 0;
		double avg = avg(values);
		int count = 0;
		
		if(values.length < 2)
			return null;
		
		while(values.hasNext()) {
			Double n = (Double) values.getNext();
			if(n == null)
				continue;
			
			double next = n - avg;
			stddev += next * next;
			count++;
		}
		
		if(count < 2)
			return null;
		
		stddev = stddev / (values.length - 1);
		stddev = java.lang.Math.sqrt(stddev);
		
		return stddev;
	}
	
	public static double gamma(double x) {
		// Additional ending criteria x < 0.5 in order to guarantee a finite function
		if(x == 1.0d || x < 0.5)
			return 1;
		else if(x == 0.5)
			return java.lang.Math.sqrt(PI);
		else
			return (x - 1d) * gamma(x - 1d);
	}
}
