class Box {
	double width;
	double height;
	double depth;
}


class box_demo {
	public static void main(String[] args) {
		Box b1 = new Box();
		Box b2 = new Box();
		double vol;

		b1.width = 10;
		b1.height = 20;
		b1.depth = 15;

		b2.width = 3;
		b2.height = 6;
		b2.depth = 9;

		print_vol(b1);
		print_vol(b2);

	}

	private static void print_vol(Box box) {
		double val = box.width * box.height * box.depth;
		System.out.println("Value is equal to " + val);
	}
}
