package list;

public class TriplePair<T> {

	private T x;
	private T y;
	private T z;
	
	public TriplePair(T x, T y, T z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public void setX(T x) {
		this.x = x;
	}
	
	public void setY(T y) {
		this.y = y;
	}
	
	public void setZ(T z) {
		this.z = z;
	}
	
	public T getX() {
		return this.x;
	}
	
	public T getY() {
		return this.y;
	}
	
	public T getZ() {
		return this.z;
	}
}
