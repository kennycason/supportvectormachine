package lib.vector;

public class Vector5D extends AbstractVector {
	
	public Vector5D() {
		this(0, 0, 0, 0, 0);
	}
	
	public Vector5D(double x, double y, double z, double u, double v) {
		super(x, y, z, u, v);
	}
	
	public double x() {
		return get(0);
	}
	
	public void x(double x) {
		set(0, x);
	}	
	
	public double y() {
		return get(1);
	}
	
	public void y(double y) {
		set(1, y);
	}	
	
	public double z() {
		return get(2);
	}
	
	public void z(double z) {
		set(2, z);
	}	
	
	public double u() {
		return get(3);
	}
	
	public void u(double u) {
		set(3, u);
	}
	
	public double v() {
		return get(4);
	}
	
	public void v(double v) {
		set(3, v);
	}
	
	public Vector5D unit() {
		Vector5D v = new Vector5D();
		double m = magnitude();
		v.x(x() / m);
		v.y(y() / m);
		v.z(z() / m);
		v.u(u() / m);
		v.v(v() / m);
		return v;
	}
	
	public Vector5D clone() {
		return new Vector5D(x(), y(), z(), u(), v());
	}
	
}
