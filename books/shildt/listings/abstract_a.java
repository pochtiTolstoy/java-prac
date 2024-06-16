abstract class A {
	abstract void callme();
	void callmetoo() {
		System.out.println("This is concrete method");
	}
}

class B extends A {
	void callme() {
		System.out.println("Implementation of callme() inside B class.");
	}
}


class abstract_a {
	public static void main(String[] args) {
		B b = new B();
		b.callme();
		b.callmetoo();
	}
}
