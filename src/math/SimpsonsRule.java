package math;

public class SimpsonsRule {

	private Float x_low;
	private Float x_high;
	private float E;
	public static final int N = 20;
	private int currentN;
	private float offset;
	private float factor = 1;
	private Function function;
	
	public SimpsonsRule(Function function, Float x_low, Float x_high, float E) {
		this.function = function;
		this.x_low = x_low;
		this.x_high = x_high;
		this.E = E;
		this.currentN = N;
		adjustBonds();
	}
	
	private void adjustBonds() {
		if(x_low == null && x_high != null) {
			if(x_high > 0) {
				offset = 0.5f;
				x_low = 0f;
			} 
			else {
				x_high = java.lang.Math.abs(x_high);
				x_low = 0f;
				offset = 0.5f;
				factor = -1f;
			}
		}
		else if(x_low != null && x_high == null) {
			if(x_low < 0) {
				offset = 0.5f;
				x_high = 0f;
			} 
			else {
				x_high = java.lang.Math.abs(x_low);
				x_low = 0f;
				offset = 0.5f;
				factor = -1f;
			}
		}
		else if(x_low == null && x_high == null) {
			x_high = 0f;
			x_low = 0f;
			offset = 1f;
		}
		else if(x_high > 0 && x_low < 0) {
			x_low = 0f;
			offset = 0.5f - (new SimpsonsRule(function, null, x_low, E).compute());
		}
		else if (x_high < 0) {
			x_high = java.lang.Math.abs(x_low);
			x_low = 0f;
			factor = -1f;
		}
	}
	
	public float compute() {
		return offset + factor * compute(0f);
	}
	
	private float compute(float oldResult) {
		float newResult =  function.calculate(x_low);
		float W = (x_high - x_low) / currentN;
		
		if(x_low == x_high) {
			return 0f;
		}
		
		for(int i = 1; i < currentN; i++) {
			if( i % 2 == 0) {
				newResult += 2f * function.calculate(x_low + i * W);
			}
			else {
				newResult += 4f * function.calculate(x_low + i * W);
			}
		}
		
		newResult += function.calculate(x_high);
		newResult *= W / 3f;
		currentN *= 2f;
		
		if(java.lang.Math.abs(newResult - oldResult) < E) {
			return newResult;
		}
		else {
			return compute(newResult);
		}
	}
}
