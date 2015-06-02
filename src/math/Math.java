package math;

import list.List;
import list.PairList;
import list.ValuePair;

public class Math {

	public static Double avgD(List<Double> values) {
		double avg = 0;
		double sum = 0;
		int count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			Double n = (Double) values.getNext();
			if(n == null)
				continue;
			
			sum += (double) values.getNext();
			count++;
		}
		
		if(count == 0)
			return 0d;
		
		avg = sum / count;
		return avg;
	}
	
	public static Double avgI(List<Integer> values) {
		double avg = 0;
		Integer sum = 0;
		int count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			Integer n = (Integer) values.getNext();
			if(n == null)
				continue;
			
			sum += n;
			count++;
		}
		
		if(count == 0)
			return 0d;
		
		avg = (double) sum / (double) count;
		return avg;
	}
	
	public static ValuePair<Double> avgI(PairList<Integer> values) {
		double avgX = 0;
		double avgY = 0;
		Integer sumX = 0;
		Integer sumY = 0;
		int count = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> next = (ValuePair<Integer>) values.getNext();
			
			if(next.getX() == null && next.getX() == null)
				continue;
			
			sumX += next.getX();
			sumY += next.getY();
			count++;
		}
		
		if(count == 0)
			return new ValuePair<Double>(0d, 0d);
		
		avgX = (double) sumX / (double) count;
		avgY = (double) sumY / (double) count;
		return new ValuePair<Double>(avgX, avgY);
	}
	
	public static Double stddevI(List<Integer> values) {
		double stddev = 0;
		double avg = avgI(values);
		int count = 0;
		
		if(values.length < 2)
			return null;
		
		while(values.hasNext()) {
			Integer n = (Integer) values.getNext();
			if(n == null)
				continue;
			
			double next = n - avg;
			stddev += next * next;
			count++;
		}
		
		if(count < 2)
			return null;
		
		stddev = stddev / (count - 1);
		stddev = java.lang.Math.sqrt(stddev);
		
		return stddev;
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
	
	public static Double stddevD(List<Double> values) {
		double stddev = 0;
		double avg = avgD(values);
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
			return java.lang.Math.sqrt(3.14);
		else
			return (x - 1f) * gamma(x - 1f);
	}
}
