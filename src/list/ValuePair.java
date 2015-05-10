package list;

public class ValuePair<T> {

	private T x;
	private T y;
	
	public ValuePair(T x, T y) {
		setX(x);
		setY(y);
	}
	
	public void setX(T x) {
		this.x = x;
	}
	
	public void setY(T y) {
		this.y = y;
	}
	
	public T getX() {
		return this.x;
	}
	
	public T getY() {
		return this.y;
	}
}
