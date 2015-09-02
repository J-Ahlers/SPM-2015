package math;

import list.List;
import list.TriplePair;
import list.TriplePairList;

public class MultipleRegressionCalculator {

	public GaussEquation calculate(TriplePairList<Number> list, List<Number> results) {
		List<Number> w = new List<Number>();
		List<Number> x = new List<Number>();
		List<Number> y = new List<Number>();
		List<Number> z = new List<Number>();
		
		List<Number> ww = new List<Number>();
		List<Number> wx = new List<Number>();
		List<Number> wy = new List<Number>();
		List<Number> wz = new List<Number>();
		
		List<Number> xx = new List<Number>();
		List<Number> xy = new List<Number>();
		List<Number> xz = new List<Number>();
		
		List<Number> yy = new List<Number>();
		List<Number> yz = new List<Number>();
		
		// Gather required data
		for(int i = 0; list.hasNext(); i++) {
			@SuppressWarnings("unchecked")
			TriplePair<Number> n = (TriplePair<Number>) list.getNext();
			if(n.getX() == null || n.getY() == null || n.getZ() == null || results.get(i) == null)
				continue;
			
			Float current_w = n.getX().floatValue();
			Float current_x = n.getY().floatValue();
			Float current_y = n.getZ().floatValue();
			Float current_z = results.get(i).floatValue();
			
			w.add(current_w);
			x.add(current_x);
			y.add(current_y);
			z.add(current_z);
			
			ww.add(current_w * current_w);
			wx.add(current_w * current_x);
			wy.add(current_w * current_y);
			wz.add(current_w * current_z);
			
			xx.add(current_x * current_x);
			xy.add(current_x * current_y);
			xz.add(current_x * current_z);
			
			yy.add(current_y * current_y);
			yz.add(current_y * current_z);
		}
		
		Float sum_w = Math.getSum(w);
		Float sum_x = Math.getSum(x);
		Float sum_y = Math.getSum(y);
		Float sum_z = Math.getSum(z);
		
		Float sum_ww = Math.getSum(ww);
		Float sum_wx = Math.getSum(wx);
		Float sum_wy = Math.getSum(wy);
		Float sum_wz = Math.getSum(wz);
		
		Float sum_xx = Math.getSum(xx);
		Float sum_xy = Math.getSum(xy);
		Float sum_xz = Math.getSum(xz);
		
		Float sum_yy = Math.getSum(yy);
		Float sum_yz = Math.getSum(yz);
		
		// Regression procedure according to table A31
		GaussEquation a = new GaussEquation((float) list.getActualCount(), sum_w, sum_x, sum_y, sum_z);
		GaussEquation b = new GaussEquation(sum_w, sum_ww, sum_wx, sum_wy, sum_wz);
		GaussEquation c = new GaussEquation(sum_x, sum_wx, sum_xx, sum_xy, sum_xz);
		GaussEquation d = new GaussEquation(sum_y, sum_wy, sum_xy, sum_yy, sum_yz);
		
//		a.print();
//		b.print();
//		c.print();
//		d.print();
		
		GaussCalculator calc = new GaussCalculator();
		return calc.solve(a, b, c, d);
	}
}
