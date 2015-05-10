package list;

public class PairList<T> extends List {

	public void add(T x, T y) {
		super.add(new ValuePair<T>(x, y));
	}
}
