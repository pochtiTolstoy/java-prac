class exc1 {
	public static void main(String[] args) {
		int d, a;
		try {
			d = 0;
			a = 42 / d;
			System.out.println("Hello, I am dog");
		} catch (ArithmeticException e) {
			System.out.println("Zero division");
		}
		System.out.println("After catch operator");
	}
}
