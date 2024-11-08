
class vector {
	private double x_;
	private double y_;
	private double z_;
	
	public vector(double x, double y, double z) {
		x_ = x; y_ = y; z_ = z;
	}
	public double length() {
		return Math.sqrt(x_ * x_ + y_ * y_ + z_ * z_);
	}

	public double scalar_prod(vector v) {
		return x_ * v.x_ + y_ * v.y_ + z_ * v.z_;
	}

	public vector cross_prod(vector v) {
		return new vector(
				y_ * v.z_ - z_ * v.y_,
				z_ * v.x_ - x_ * v.z_,
				x_ * v.y_ - y_ * v.x_
			);
	}

	public double cos(vector v) {
		return scalar_prod(v) / (length() * v.length());
	}

	public vector add(vector v) {
		return new vector(
				x_ + v.x_,
				y_ + v.y_,
				z_ + v.z_
			);
	}

	public vector subtract(vector v) {
		return new vector(
				x_ - v.x_,
				y_ - v.y_,
				z_ - v.z_
			);
	}

	public static int get_int(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	public static vector[] generate(int n) {
		vector[] vectors = new vector[n];
		for (int i = 0; i < n; ++i)
			vectors[i] = new vector(get_int(-5, 5), get_int(-5, 5), get_int(-5, 5));
		return vectors;
	}

	@Override
	public String toString() {
		return "Vector{" + 
					 "x=" + x_ + ", " +
					 "y=" + y_ + ", " +
					 "z=" + z_ + '}';
	}
}

class t1 {
	public static void main(String[] args) {
		vector[] vectors = vector.generate(10);
		System.out.println(vectors[0]);
		System.out.println(vectors[1]);
		System.out.println(vectors[0].length());
		System.out.println(vectors[0].scalar_prod(vectors[1]));
		System.out.println(vectors[0].cross_prod(vectors[1]));
		System.out.println(vectors[0].cos(vectors[1]));
		System.out.println(vectors[0].add(vectors[1]));
		System.out.println(vectors[0].subtract(vectors[1]));
	}
}
