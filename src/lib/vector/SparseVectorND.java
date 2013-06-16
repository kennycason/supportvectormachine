package lib.vector;

public class SparseVectorND extends AbstractSparseVector {

	public SparseVectorND() {
		super(0);
	}

	public SparseVectorND unit() {
		SparseVectorND v = new SparseVectorND();
		double m = magnitude();
		for(int i = 0; i < size(); i++) {
			v.set(i, get(i) / m);
		}
		return v;
	}
	
}
