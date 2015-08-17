package math;

import list.List;
import list.ListSort;
import math.Math;
import math.distributions.NormalDistribution;
import math.distributions.X2Distribution;

public class DistributionDegreeCalculator {

	public float calculateDegree(List<List<Number>> list, int index) {
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
	
	public float calculateDegree(List<Number> list) {
		if(list.length < 15)
			return 0f;
		
		// Sort list (is needed later on)
		list = ListSort.sort(list);
		//list.print();
		
		// 1. Calculating the average
		float avg = Math.avg(list);
		//System.out.println("avg: " + avg);
		
		// 2. Calculating the variance
		float o2 = 0f;
		while(list.hasNext()) {
			Number n = (Number) list.getNext();
			if(n == null)
				continue;
			
			o2 += (n.floatValue() - avg) * (n.floatValue() - avg);
		}
		o2 = o2 / ((float) list.length - 1f);
		
		
		// 3. Calculating o
		float o = (float) java.lang.Math.sqrt(o2);
		//System.out.println("o: " + o);
		
		// 4. Normalizing the list
		List<Number> z = new List<Number>();
		while(list.hasNext()) {
			Number n = (Number) list.getNext();
			if(n == null)
				continue;
			
			z.add((n.floatValue() - avg) / o);
		}
		z = ListSort.sort(z);
		//z.print();
		//System.out.println("z count:" + z.length);
		
		
		// 6. Determine segments (guaranteeing an 'integer')
		float s = (float) java.lang.Math.sqrt(list.length);
		if(s < 3) {
			s = 3f;
		} else {
			// ceil s
			int tmp = (int) (s + 1);
			s = (float) tmp;
		}
		// For debug purposes
		s = 10f;
		
		// 7. Construct segments
		List<Number> segments = new List<Number>();
		float limit = 0;
		for(int i = 0; i < s - 1; i++) {
			limit += 1d / s;
			float tmpsegmentlimit = getSegment(limit);
			//System.out.println("seglimit: " + tmpsegmentlimit);
			segments.add(tmpsegmentlimit);
		}
		
		
		// 8. Determining actual population of the segments
		List<Number> segmentpopulation = new List<Number>();
		Float upperlimit = null;
		Float lowerlimit = null;
		while(segments.hasNext()) {
			// get current segment (upper limit)
			Number seg = (Number) segments.getNext();
			upperlimit = seg.floatValue();
			
			int count = 0;
			while(z.hasNext()) {
				Number n = z.getNext();
				if(n == null)
					continue;
				
				float zi = n.floatValue();
				
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
			
			float zi = n.floatValue();
			
			if(upperlimit != null && zi > upperlimit) {
				finalcount++;
			}
		}
		if(finalcount > 0)
			finalcount++;
		segmentpopulation.add(finalcount);
		//segmentpopulation.print();
		
		// 9. Calculating q
		float q = 0;
		float ni = (float) list.length / (float) segmentpopulation.length;
		while(segmentpopulation.hasNext()) {
			Number n = (Number) segmentpopulation.getNext();
			if(n == null)
				continue;
			
			float ki = n.floatValue();
			q += ((ni - ki) * (ni - ki)) / ni;
		}
		System.out.println("Q: " + q);
		
		// 10. + 11.
		SimpsonsRule r = new SimpsonsRule(new X2Distribution((int) s - 1), 0f, (float) q, 0.00001f);
		float p = r.compute();
		//System.out.println(p);
		return 1 - p;
	}
	
	private float getSegment(double size) {
		float currentPrecision = 0.0f;
		float currentValue = -10.0f;
		while(currentPrecision < size) {
			currentValue += 0.001f;
			SimpsonsRule r3 = new SimpsonsRule(new NormalDistribution(), null, currentValue, 0.001f);
			currentPrecision = r3.compute();
		}
		return currentValue;
	}
}
