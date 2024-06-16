class nest_try {
	public static void main(String[] args) {
		try {
			int a = args.length;
			int b = 42 / a;
			System.out.println("a = " + a);
			try {
				if (a == 1) a = a / (a - a);
				if (a == 2) {
					int[] c = { 1 };
					c[42] = 99; // out of bounds
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Index is out of bounds in array: " + e);
			}
		} catch (ArithmeticException e) {
			System.out.println("Zero division: " + e);	
		}
	}
}
