package p2;

class other_package {
	other_package() {
		p1.protection p = new p1.protection();
		System.out.println("Ctr of p2:other_package");
	}
}
