package p1;

class derived extends protection {
	derived() {
		System.out.println("Ctr of derived");
		System.out.println("n = " + n);
		// only class protection
		// System.out.println("n_pri = " + n_pri);
		System.out.println("n_pro = " + n_pro);
		System.out.println("n_pub = " + n_pub);
	}
}
