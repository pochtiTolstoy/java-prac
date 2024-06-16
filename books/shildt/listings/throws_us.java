class throws_us {
	static void throwOne() throws IllegalAccessException {
		System.out.println("Inside throwOne().");
		throw new IllegalAccessException("demonstration");
	}
	public static void main(String[] args) {
		try {
			throwOne();
		} catch (IllegalAccessException e) {
			System.out.println("Catch it: " + e);
		}
	}
}
