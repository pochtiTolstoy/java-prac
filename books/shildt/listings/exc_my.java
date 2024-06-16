class MyExc extends Exception {
	private int detail;
	MyExc(int a) {
		detail = a;
	}
	public String toString() {
		return "MyExc[" + detail + "]";
	}
}

class exc_my {
	static void compute(int a) throws MyExc {
		System.out.println("Call compute(" + a + ")");	
		if (a > 10)
			throw new MyExc(a);
		System.out.println("Normal exec");
	}
	public static void main(String[] args) {
		try {
			compute(1);
			compute(200);
		} catch (MyExc e) {
			System.out.println("Catch exception: " + e);
		}
	}
}
