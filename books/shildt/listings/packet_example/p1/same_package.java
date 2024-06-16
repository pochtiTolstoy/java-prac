package p1;

class same_package {
	same_package() {
		protection p = new protection();
		System.out.println("Ctr of same_package");
		System.out.println("n = " + p.n);
		System.out.println("n_pro = " + p.n_pro);
		System.out.println("n_pub = " + p.n_pub);
	}
}
