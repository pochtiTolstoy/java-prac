/**
 * Represents an immutable 3D-vector
 */
interface Vector {
	/**
	 * Returns a vector component
	 * @param n component number, must be 0 (X), 1 (Y) or 2 (Z)
	 * @return a value of the corresponding vector component
	 */
	public double component(int n);
	/**
	 * @return a vector length
	 */
  public double length();
	/**
	 * Sums two vectors
	 * @param other a vector to add to this vector
	 * @return a result of addition
	 */
  public Vector plus(Vector other);
	/**
	 * Default toString method for output representation
	 */
	public String toString();
}

class FieldVector implements Vector {
	double x, y, z;
	FieldVector(double x, double y, double z) {
		this.x = x; this.y = y; this.z = z;
	}

	@Override
	public double component(int n) {
		switch (n) {
			case 0: return x;
			case 1: return y;
			case 2: return z;
			default: throw new IllegalArgumentException();
		}
	}

	@Override
	public double length() { return Math.sqrt(x * x + y * y + z * z); }

	@Override
	public Vector plus(Vector other) {
		return new FieldVector(x + other.component(0),
													 y + other.component(1),
													 z + other.component(2));
	}

	@Override
	public String toString() {
		return new String("Vector<" + x + ", " + y + ", " + z + ">");
	}
}

class ZeroVector implements Vector {
	public static final ZeroVector INSTANCE = new ZeroVector();
	private ZeroVector() {}

	@Override
	public double component(int n) { return 0; }

	@Override
	public double length() { return 0; }

	@Override
	public Vector plus(Vector other) { return other; } // maybe ok, because
																										 // object is immutable
	@Override
	public String toString() {
		return "Vector<0, 0, 0>";
	}
}

public class vector_impl {
	public static void main(String[] args) {
		var v1 = new FieldVector(3, 4, 5);
		var v2 = new FieldVector(-3, -4, 5);
		System.out.println(v1.component(1));
		System.out.println(v1.length());
		var v3 = v1.plus(v2);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		var v4 = v3.plus(ZeroVector.INSTANCE);
		var v5 = (ZeroVector.INSTANCE).plus(ZeroVector.INSTANCE);
		var v6 = ZeroVector.INSTANCE;
		System.out.println(v4);
		System.out.println(v5);
		System.out.println(v6);
	}
}
