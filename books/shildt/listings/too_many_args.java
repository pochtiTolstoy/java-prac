class var_args {
	static void va_test(int... v) {
		System.out.print("Number of args: " + v.length + ", contains: ");
		for (int x: v) System.out.print(x + " ");
		System.out.println();
	}
}

class too_many_args {
	public static <T> void reverse(T num) {
		System.out.print(num + " ");
	}
	@SafeVarargs
	public static <T> void reverse(T num, T... v) {
		if (v.length > 0) reverse(v[0], java.util.Arrays.copyOfRange(v, 1, v.length));
		reverse(num);
	}
	public static void main(String[] args) {
		var_args.va_test(10);
		var_args.va_test(1, 2, 3);
		var_args.va_test();
		reverse(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println();
	}
}
