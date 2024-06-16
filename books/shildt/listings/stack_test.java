class stack {
	int st[] = new int[10];
	int ind;
	stack() { ind = -1; }
	void push(int key) {
		if (ind == 9) {
			System.out.println("Stack is full");
			return;
		}
		st[++ind] = key;
	}
	int pop() {
		if (ind < 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		return st[ind--];
	}
}

class stack_test {
	public static void main(String[] args) {
		stack st1 = new stack();
		stack st2 = new stack();

		for (int i = 0; i < 10; ++i) st1.push(i);
		for (int i = 10; i < 20; ++i) st2.push(i);

		System.out.println("Stack in st1:");
		for (int i = 0; i < 10; ++i) {
			System.out.println(st1.pop());
		}

		System.out.println("Stack in st1:");
		for (int i = 0; i < 10; ++i) {
			System.out.println(st2.pop());
		}

	}
}
