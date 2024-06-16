package mypack;

class Balance {
	String name;
	double bal;
	Balance(String n, double b) {
		name = n;
		bal = b;
	}
	void show() {
		System.out.println("--> ");
		System.out.println(name + ": $" + bal);
	}
}

class account_balance {
	public static void main(String[] args) {
		Balance[] current = new Balance[3];
		current[0] = new Balance("Tim", 123.23);
		current[1] = new Balance("Tom", 10.23);
		current[2] = new Balance("Bob", 1);
		for (int i = 0; i < 3; ++i) current[i].show();
	}
}
