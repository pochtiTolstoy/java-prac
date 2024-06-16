class A {
	public interface nested_if {
		boolean is_not_negative(int x);
	}
}

class B implements A.nested_if {
	public boolean is_not_negative(int x) {
		return x < 0 ? false : true;
	}
}

class interface_inside {
	public static void main(String[] args) {
		A.nested_if nif = new B();	
		if (nif.is_not_negative(10)) System.out.println("10 is not negative");
		if (nif.is_not_negative(-12)) System.out.println("AAAAAAAAAA");
	}
}
