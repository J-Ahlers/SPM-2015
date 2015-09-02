package math;

import list.List;
import list.TriplePair;
import list.TriplePairList;

public class MultipleRegressionPredictionInterval {

	public float calculate(TriplePairList<Number> list, List<Number> results, GaussEquation relation, float precision) {
		
		float o_sum = 0f;
		float b0 = relation.getB0();
		float b1 = relation.getB1();
		float b2 = relation.getB2();
		float b3 = relation.getB3();
		
		List<Number> w = new List<Number>();
		List<Number> x = new List<Number>();
		List<Number> y = new List<Number>();
		List<Number> z = new List<Number>();
		
		/**
		* Calculate A20
		**/
		for(int i = 0; list.hasNext(); i++) {
			@SuppressWarnings("unchecked")
			TriplePair<Number> n = (TriplePair<Number>) list.getNext();
			if(n.getX() == null || n.getY() == null || n.getZ() == null || results.get(i) == null)
				continue;
			
			Float w_i = n.getX().floatValue();
			Float x_i = n.getY().floatValue();
			Float y_i = n.getZ().floatValue();
			Float z_i = results.get(i).floatValue();
			
			w.add(w_i);
			x.add(x_i);
			y.add(y_i);
			z.add(z_i);
			
			float tmp = z_i - b0 - b1 * w_i - b2 * x_i - b3 * y_i;
			o_sum += tmp * tmp;
		}
		
		float o = (float) ( 1 / ((float) list.getActualCount() - 4f) ) * o_sum;
		o = (float) java.lang.Math.sqrt(o);
		
		/**
		* Calculate variables needed for A21
		**/
		
		Float w_avg = Math.avg(w);
		Float x_avg = Math.avg(x);
		Float y_avg = Math.avg(y);
		
		float w_k = (relation.getX1() - w_avg) * (relation.getX1() - w_avg);
		float x_k = (relation.getX2() - x_avg) * (relation.getX2() - x_avg);
		float y_k = (relation.getX3() - y_avg) * (relation.getX3() - y_avg);
		
		float w_sum = 0f;
		float x_sum = 0f;
		float y_sum = 0f;
		
		for(int i = 0; list.hasNext(); i++) {
			@SuppressWarnings("unchecked")
			TriplePair<Number> n = (TriplePair<Number>) list.getNext();
			if(n.getX() == null || n.getY() == null || n.getZ() == null || results.get(i) == null)
				continue;
			
			Float w_i = n.getX().floatValue();
			Float x_i = n.getY().floatValue();
			Float y_i = n.getZ().floatValue();
			
			w_sum += (w_i - w_avg) * (w_i - w_avg);
			x_sum += (x_i - x_avg) * (x_i - x_avg);
			y_sum += (y_i - y_avg) * (y_i - y_avg);
		}
		
		float t = RangeCalculator.getAlpha(list.getActualCount() - 4, precision);
//		System.out.println("t (" + precision + "): " + t);
//		System.out.println("o: " + o);
		
		/**
		* Calculate A21
		**/
		float range = (float) (t * o * java.lang.Math.sqrt( 1 + 1f / (float) list.getActualCount() + w_k / w_sum + x_k / x_sum + y_k / y_sum));
		return range;
	}
}
