class throw_me {
	static void demoproc() {
		try {
			throw new NullPointerException("demonstration");
		} catch (NullPointerException e) {
			System.out.println("Catch it inside demoproc().");
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			demoproc();
		} catch (NullPointerException e) {
			System.out.println("Catch it inside main again: " + e);
		}
	}
}
