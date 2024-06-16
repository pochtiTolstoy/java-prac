interface stack {
	void push(int key);
	int pop();
}

class dyn_stack implements stack {
	private int[] stack_;
	private int top_;

	dyn_stack(int size) {
		stack_ = new int[size];
		top_ = 0;
	}
	public void push(int key) {
		if (top_ == stack_.length) {
			int[] temp = new int[stack_.length * 2];
			for (int i = 0; i < stack_.length; ++i)
				temp[i] = stack_[i];
			stack_ = temp;
		}
		stack_[top_++] = key;
	}

	public int pop() {
		if (top_ <= 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		return stack_[--top_];
	}
}

class fixed_stack implements stack {
	private int[] stack_;
	private int top_;
	fixed_stack(int size) {
		stack_ = new int[size];
		top_ = 0;
	}

	public void push(int key) {
		if (top_ == stack_.length)
			System.out.println("Stack is full");
		else
			stack_[top_++] = key;
	}

	public int pop() {
		if (top_ <= 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		return stack_[--top_];
	}
}

class stack_int {
	public static void main(String[] args) {
		fixed_stack s1 = new fixed_stack(5);
		fixed_stack s2 = new fixed_stack(8);

		for (int i = 0; i < 5; ++i) s1.push(i);
		for (int i = 0; i < 8; ++i) s2.push(i);

		System.out.println("Stack in s1:");
		for (int i = 0; i < 5; ++i)
			System.out.print(s1.pop());
		System.out.println("\nStack in s2:");
		for (int i = 0; i < 8; ++i)
			System.out.print(s2.pop());
		System.out.println();

		dyn_stack d1 = new dyn_stack(5);
		dyn_stack d2 = new dyn_stack(8);
		for (int i = 0; i < 12; ++i) d1.push(i);
		for (int i = 0; i < 20; ++i) d2.push(i);

		System.out.println("stack d1:");
		for (int i = 0; i < 12; ++i) {
			System.out.print(d1.pop() + " ");
		}
		System.out.println();
		System.out.println("stack d2:");
		for (int i = 0; i < 20; ++i) {
			System.out.print(d2.pop() + " ");
		}
		System.out.println();
	}
}
