package math;

import list.PairList;
import list.ValuePair;

public class CorrelationCalculator {
	
	public double getCorrelation(PairList<Number> values) {
		Double x = 0d;
		Double y = 0d;
		Double xy = 0d;
		Double xx = 0d;
		Double yy = 0d;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> n = (ValuePair<Number>) values.getNext();
			if(n.getX() == null || n.getY() == null)
				continue;
			
			x += n.getX().doubleValue();
			y += n.getY().doubleValue();
			xy += n.getX().doubleValue() * n.getY().doubleValue();
			xx += n.getX().doubleValue() * n.getX().doubleValue();
			yy += n.getY().doubleValue() * n.getY().doubleValue();
		}
		
		double top = (values.getActualCount() * xy) - (x * y);
		double bottom1 = (values.getActualCount() * xx) - (x * x);
		double bottom2 = (values.getActualCount() * yy) - (y * y);
		
		double result = top / java.lang.Math.sqrt(bottom1 * bottom2);
		
//		System.out.println(values.getActualCount()+" * "+xy+" - "+x+" * "+y);
//		System.out.println("("+values.getActualCount()+" * "+xx+" - "+x+"^2) * ("+values.getActualCount()+" * "+yy+" - "+y+"^2)");
		
		return result;
	}
}
