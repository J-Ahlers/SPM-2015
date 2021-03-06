package math;

import list.PairList;
import list.ValuePair;

public class RegressionCalculator {
	
	private PairList<Number> project;
	
	public RegressionCalculator() {
		this.project = new PairList<Number>();
	}
	
	public RegressionCalculator(PairList<Number> project) {
		this.project = project;
	}
	
	public void add(int x, int y) {
		this.project.add(x, y);
	}
	
	public float getB1() {
		int xy = 0;
		int xx = 0;
		int count = 0;		
		
		ValuePair<Float> avg = Math.avg(this.project);
		while(this.project.hasNext()) {
			@SuppressWarnings("unchecked")
			ValuePair<Integer> next = (ValuePair<Integer>) this.project.getNext();
			if(next.getX() == null && next.getX() == null)
				continue;
			
			xy += next.getX() * next.getY();
			xx += next.getX() * next.getX();
			count++;
		}
		if(( xx - count * avg.getX() * avg.getX() ) == 0)
			return 0;
		 
		return ( xy - this.project.length * avg.getX() * avg.getY() ) / ( xx - count * avg.getX() * avg.getX() );
	}
	
	public float getB0() {
		ValuePair<Float> avg = Math.avg(this.project);
		return avg.getY() - getB1() * avg.getX();
	}
	

}
