package lib.vector;

public class Vector4D extends AbstractVector {
	
	public Vector4D() {
		this(0, 0, 0, 0);
	}
	
	public Vector4D(double x, double y, double z, double u) {
		super(x, y, z, u);
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
	
	public Vector4D unit() {
		Vector4D v = new Vector4D();
		double m = magnitude();
		v.x(x() / m);
		v.y(y() / m);
		v.z(z() / m);
		v.u(u() / m);
		return v;
	}
	
	public Vector4D clone() {
		return new Vector4D(x(), y(), z(), u());
	}
	
}
