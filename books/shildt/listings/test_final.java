import java.util.Scanner;

class Box {
	final int TEST_;
	int cols_;
	Box() {
		cols_ = 0;
		TEST_ = 10;
	}
	Box(int x, int y) {
		cols_ = x;
		TEST_ = y;
	}
	public void print_data() {
		System.out.println("cols_ = " + cols_);
		System.out.println("TEST_ = " + TEST_);
	}
}

class test_final {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter integer: ");

		int a = input.nextInt();

		Box b1 = new Box();
		b1.print_data();
		Box b2 = new Box(100, a);
		b2.print_data();
	}
}
