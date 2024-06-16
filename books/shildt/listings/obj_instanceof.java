record Point(int x, int y) {
	void print() {
		System.out.println("Point<" + x + "," + y + ">");
	}
}

public class obj_instanceof {
	public static void main(String[] args) {
		Point p = new Point(3, 4);
		process(p);
		f();
	}

	private static void process(Object obj) {
		if (obj instanceof Point) {
			Point point = (Point) obj;
			point.print();
		}
	}

	private static void f() {
		System.out.println("Hello");
	}
}
