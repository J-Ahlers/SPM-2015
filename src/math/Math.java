package math;

import list.List;
import list.PairList;
import list.ValuePair;

public class Math {

	public static Double avgD(List<Double> values) {
		double avg = 0;
		double sum = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			sum += (double) values.getNext();
		}
		avg = sum / values.length;
		return avg;
	}
	
	public static Double avgI(List<Integer> values) {
		double avg = 0;
		Integer sum = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			sum += (Integer) values.getNext();
		}
		avg = (double) sum / (double) values.length;
		return avg;
	}
	
	public static ValuePair<Double> avgI(PairList<Integer> values) {
		double avgX = 0;
		double avgY = 0;
		Integer sumX = 0;
		Integer sumY = 0;
		
		if(values.isEmpty())
			return null;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> next = (ValuePair<Integer>) values.getNext();
			sumX += next.getX();
			sumY += next.getY();
		}
		avgX = (double) sumX / (double) values.length;
		avgY = (double) sumY / (double) values.length;
		return new ValuePair<Double>(avgX, avgY);
	}
	
	public static Double stddevI(List<Integer> values) {
		double stddev = 0;
		double avg = avgI(values);
		
		if(values.length <= 1)
			return null;
		
		while(values.hasNext()) {
			double next = ((Integer) values.getNext()) - avg;
			stddev += next * next;
		}
		
		stddev = stddev / (values.length - 1);
		stddev = java.lang.Math.sqrt(stddev);
		
		return stddev;
	}
	
	public static Double stddevD(List<Double> values) {
		double stddev = 0;
		double avg = avgD(values);
		
		if(values.length <= 1)
			return null;
		
		while(values.hasNext()) {
			double next = ((double) values.getNext()) - avg;
			stddev += next * next;
		}
		
		stddev = stddev / (values.length - 1);
		stddev = java.lang.Math.sqrt(stddev);
		
		return stddev;
	}
}
