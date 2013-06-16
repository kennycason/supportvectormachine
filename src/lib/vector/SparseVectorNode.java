package lib.vector;

public class SparseVectorNode {

	private int index;
	
	private double value;
	
	public SparseVectorNode(int index, double value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex() {
		return index;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
}
