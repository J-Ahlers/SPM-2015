package math;


public class GaussEquation implements Cloneable {

	private float x0;
	private float b0 = 1f;
	private float x1;
	private float b1 = 1f;
	private float x2;
	private float b2 = 1f;
	private float x3;
	private float b3 = 1f;
	private float x4;
	
	public GaussEquation(float x0, float x1, float x2, float x3, float x4) {
		setX0(x0);
		setX1(x1);
		setX2(x2);
		setX3(x3);
		setX4(x4);
	}
	
	public GaussEquation(float b0, float b1, float b2, float b3) {
		setB0(b0);
		setB1(b1);
		setB2(b2);
		setB3(b3);
		setX0(0);
		setX1(0);
		setX2(0);
		setX3(0);
		setX4(0);
	}
	
	/**
	* Adds the given equation to this object
	**/
	public void add(GaussEquation eq) {
		setX0(this.getX0() + eq.getX0());
		
		setX1(this.getX1() + eq.getX1());
		
		setX2(this.getX2() + eq.getX2());
		
		setX3(this.getX3() + eq.getX3());
		
		setX4(this.getX4() + eq.getX4());
	}
	
	/**
	* Substracts the given equation to this object
	**/
	public void substract(GaussEquation eq) {
		setX0(this.getX0() - eq.getX0());
		
		setX1(this.getX1() - eq.getX1());
		
		setX2(this.getX2() - eq.getX2());
		
		setX3(this.getX3() - eq.getX3());
		
		setX4(this.getX4() - eq.getX4());
	}
	
	/**
	* Multiplies this object with the given factor
	**/
	public void multiply(float x) {
		setX0(this.getX0() * x);
		
		setX1(this.getX1() * x);
		
		setX2(this.getX2() * x);
		
		setX3(this.getX3() * x);
		
		setX4(this.getX4() * x);
	}
	
	/**
	* Divides this object by the given factor
	**/
	public void divide(float x) {
		setX0(this.getX0() / x);
		
		setX1(this.getX1() / x);
		
		setX2(this.getX2() / x);
		
		setX3(this.getX3() / x);
		
		setX4(this.getX4() / x);
	}

	public float getX0() {
		return x0;
	}

	public void setX0(float x0) {
		this.x0 = x0;
	}

	public float getB0() {
		return b0;
	}

	public void setB0(float b0) {
		this.b0 = b0;
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getB1() {
		return b1;
	}

	public void setB1(float b1) {
		this.b1 = b1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public float getB2() {
		return b2;
	}

	public void setB2(float b2) {
		this.b2 = b2;
	}

	public float getX3() {
		return x3;
	}

	public void setX3(float x3) {
		this.x3 = x3;
	}

	public float getB3() {
		return b3;
	}

	public void setB3(float b3) {
		this.b3 = b3;
	}

	public float getX4() {
		return x4;
	}

	public void setX4(float x4) {
		this.x4 = x4;
	}	
		
	public float get0() {
		return getX0() * getB0();
	}
			
	public float get1() {
		return getX1() * getB1();
	}
			
	public float get2() {
		return getX2() * getB2();
	}
			
	public float get3() {
		return getX3() * getB3();
	}
	
	@Override
	protected GaussEquation clone() {
		try {
			return (GaussEquation) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void print() {
		System.out.println(get0() + " " + get1() + " " + get2() + " " + get3() + " " + getX4());
	}
}
