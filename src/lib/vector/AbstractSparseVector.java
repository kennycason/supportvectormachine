package lib.vector;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class AbstractSparseVector implements IVector {
	
	protected ArrayList<SparseVectorNode> vals;
	
	protected int size = 0;
	
	protected AbstractSparseVector(int size) {
		vals = new ArrayList<SparseVectorNode>(size);
		this.size = size;
	}
	
	protected AbstractSparseVector(SparseVectorNode[] nodes) {
		vals = new ArrayList<SparseVectorNode>();
		for(SparseVectorNode node : nodes) {
			set(node.getIndex(), node.getValue());
		}
	}
	
	public double get(int i) {
		if(i >= size()) {
			return 0;
		}
		for(int j = 0; j < vals.size(); j++) {
			if(vals.get(j).getIndex() == i) {
				return vals.get(j).getValue();
			} else if(vals.get(j).getIndex() > i) {
				return 0;
			}		
		}
		return 0;
	}
	
	public void set(int i, double value) { 
		if(value == 0) {
			return;
		}
		if(vals.size() == 0) {
			vals.add(new SparseVectorNode(i, value));
			size = i + 1;
		} else if(vals.get(vals.size() - 1).getIndex() < i) {
				vals.add(new SparseVectorNode(i, value));
				size = i + 1;
		} else {
			for(int j = 0; j < vals.size(); j++) {
				if(vals.get(j).getIndex() == i) {
					vals.get(j).setValue(value);
				} else if(vals.get(j).getIndex() > i) { // doesn't exist
					vals.add(j, new SparseVectorNode(i, value));
					break;
				} 
			}
		}

	}

	public void setAll(double ... values) {
		for(int i = 0; i < values.length; i++) {
			set(i, values[i]);
		}
		size = values.length;
	}
	
	public double[] get() {
		double[] val = new double[vals.size()];
		for(int i = 0; i < size(); i++) {
			val[i] = get(i);
		}
		return val;
	}
	
	public double magnitude() {
		double magnitude = 0;
		for(int i = 0; i < size(); i++) {
			magnitude += get(i) * get(i);
		}
		magnitude = Math.sqrt(magnitude);
		return magnitude;
	}
	
	public double dot(IVector vector) {
		int maxSize = size() > vector.size() ? size() : vector.size();
		double dot = 0;
		for(int i = 0; i < maxSize; i++) {
			dot += get(i) * vector.get(i);
		}
		return dot;
	}
	
	public double distanceSquared(IVector vector) {
		int maxSize = size() > vector.size() ? size() : vector.size();
		double distanceSquared = 0;
		for(int i = 0; i < maxSize; i++) {
			distanceSquared += (get(i) - vector.get(i)) * (get(i) - vector.get(i));
		}
		return distanceSquared;
	}
	
	public double distance(IVector vector) {
		return Math.sqrt(distanceSquared(vector));
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		DecimalFormat dFormat = new DecimalFormat("0.00");
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(int i = 0; i < size(); i++) {
			if(get(i) != 0) {
				sb.append(i + ":" + dFormat.format(get(i)));
				if(i < size() - 1) {
					sb.append(", ");
				}
			}
		}
		sb.append(")");
		return sb.toString();
	}

}
