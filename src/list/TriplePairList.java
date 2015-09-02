package list;

public class TriplePairList<T> extends List<Object> {

	public void add(T x, T y, T z) {
		super.add(new TriplePair<T>(x, y, z));
	}
}
