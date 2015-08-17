package math;

import list.PairList;
import list.ValuePair;

public class CorrelationCalculator {
	
	public float getCorrelation(PairList<Number> values) {
		Float x = 0f;
		Float y = 0f;
		Float xy = 0f;
		Float xx = 0f;
		Float yy = 0f;
		
		while(values.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Number> n = (ValuePair<Number>) values.getNext();
			if(n.getX() == null || n.getY() == null)
				continue;
			
			x += n.getX().floatValue();
			y += n.getY().floatValue();
			xy += n.getX().floatValue() * n.getY().floatValue();
			xx += n.getX().floatValue() * n.getX().floatValue();
			yy += n.getY().floatValue() * n.getY().floatValue();
		}
		
		float top = (values.getActualCount() * xy) - (x * y);
		float bottom1 = (values.getActualCount() * xx) - (x * x);
		float bottom2 = (values.getActualCount() * yy) - (y * y);
		
		float result = (float) (top / java.lang.Math.sqrt(bottom1 * bottom2));
		
//		System.out.println(values.getActualCount()+" * "+xy+" - "+x+" * "+y);
//		System.out.println("("+values.getActualCount()+" * "+xx+" - "+x+"^2) * ("+values.getActualCount()+" * "+yy+" - "+y+"^2)");
		
		return result;
	}
}
