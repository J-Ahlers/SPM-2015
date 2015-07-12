package math;

import list.List;
import list.ListSort;
import math.Math;
import math.distributions.NormalDistribution;
import math.distributions.X2Distribution;

public class DistributionDegreeCalculator {

	public double calculateDegree(List<List<Number>> list, int index) {
		// Extract the desired dataset
		List<Number> values = new List<Number>();
		while(list.hasNext()) {
			List<Number> n = list.getNext();
			if(n == null)
				continue;
			
			values.add(n.get(index));
		}
		return calculateDegree(values);
	}
	
	public double calculateDegree(List<Number> list) {
		if(list.length < 15)
			return 0d;
		
		// Sort list (is needed later on)
		list = ListSort.sort(list);
		//list.print();
		
		// 1. Calculating the average
		double avg = Math.avg(list);
		//System.out.println("avg: " + avg);
		
		// 2. Calculating the variance
		double o2 = 0d;
		while(list.hasNext()) {
			Number n = (Number) list.getNext();
			if(n == null)
				continue;
			
			o2 += (n.doubleValue() - avg) * (n.doubleValue() - avg);
		}
		o2 = o2 / ((double) list.length - 1d);
		
		
		// 3. Calculating o
		double o = java.lang.Math.sqrt(o2);
		//System.out.println("o: " + o);
		
		// 4. Normalizing the list
		List<Number> z = new List<Number>();
		while(list.hasNext()) {
			Number n = (Number) list.getNext();
			if(n == null)
				continue;
			
			z.add((n.doubleValue() - avg) / o);
		}
		z = ListSort.sort(z);
		//z.print();
		//System.out.println("z count:" + z.length);
		
		
		// 6. Determine segments (guaranteeing an 'integer')
		double s = java.lang.Math.sqrt(list.length);
		if(s < 3) {
			s = 3d;
		} else {
			// ceil s
			int tmp = (int) (s + 1);
			s = (double) tmp;
		}
		// For debug purposes
		s = 10d;
		
		// 7. Construct segments
		List<Number> segments = new List<Number>();
		double limit = 0;
		for(int i = 0; i < s - 1; i++) {
			limit += 1d / s;
			double tmpsegmentlimit = getSegment(limit);
			//System.out.println("seglimit: " + tmpsegmentlimit);
			segments.add(tmpsegmentlimit);
		}
		
		
		// 8. Determining actual population of the segments
		List<Number> segmentpopulation = new List<Number>();
		Double upperlimit = null;
		Double lowerlimit = null;
		while(segments.hasNext()) {
			// get current segment (upper limit)
			Number seg = (Number) segments.getNext();
			upperlimit = seg.doubleValue();
			
			int count = 0;
			while(z.hasNext()) {
				Number n = z.getNext();
				if(n == null)
					continue;
				
				double zi = n.doubleValue();
				
				if(lowerlimit == null && zi <= upperlimit) {
					count++;
				} else if (lowerlimit == null || zi > upperlimit) {
					// z is sorted so it is impossible to find further candidates beyond this point
					break;
				} else if (zi > lowerlimit) {
					count++;
				}
			}
			if(count > 0)
				count++;
			segmentpopulation.add(count);
			
			// 'save' current upper limit as lower limit for next round
			lowerlimit = upperlimit;
		}
		// calculating the last quarter to infinity
		int finalcount = 0;
		while(z.hasNext()) {
			Number n = (Number) z.getNext();
			
			double zi = n.doubleValue();
			
			if(upperlimit != null && zi > upperlimit) {
				finalcount++;
			}
		}
		if(finalcount > 0)
			finalcount++;
		segmentpopulation.add(finalcount);
		//segmentpopulation.print();
		
		// 9. Calculating q
		double q = 0;
		double ni = (double) list.length / (double) segmentpopulation.length;
		while(segmentpopulation.hasNext()) {
			Number n = (Number) segmentpopulation.getNext();
			if(n == null)
				continue;
			
			double ki = n.doubleValue();
			q += ((ni - ki) * (ni - ki)) / ni;
		}
		System.out.println("Q: " + q);
		
		// 10. + 11.
		SimpsonsRule r = new SimpsonsRule(new X2Distribution((int) s - 1), 0f, (float) q, 0.00001f);
		double p = r.compute();
		//System.out.println(p);
		return 1 - p;
	}
	
	private double getSegment(double size) {
		double currentPrecision = 0.0f;
		float currentValue = -10.0f;
		while(currentPrecision < size) {
			currentValue += 0.001f;
			SimpsonsRule r3 = new SimpsonsRule(new NormalDistribution(), null, currentValue, 0.001f);
			currentPrecision = r3.compute();
		}
		return currentValue;
	}
}
