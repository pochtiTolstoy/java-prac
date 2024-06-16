class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point<" + x + "," + y + ">";
	}
}

public class smart_to_string {
	public static void main(String[] args) {
		Point p = new Point(3, 4);	
		System.out.println(p);
	}
}
