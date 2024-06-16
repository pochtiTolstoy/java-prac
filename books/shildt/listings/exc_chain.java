class exc_chain {
	static void demoproc() {
		NullPointerException e = new NullPointerException("upper level");
		e.initCause(new ArithmeticException("cause")); // exception reason
		throw e;
	}
	public static void main(String[] args) {
		try {
			demoproc();
		} catch (NullPointerException e) {
			System.out.println("Catch: " + e);
			System.out.println("Main reason: " + e.getCause());
		}
	}
}
