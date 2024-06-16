#include <iostream>

class A {
protected:
	void hello() {
		std::cout << "Hello world!\n";
	}
};

class B: public A {
public:
	void test(A other) {
		this->hello();
		A::hello();
		other.hello();
	}
};

int main() {
	B b();	
	A a();
	b.test(a);
	return 0;
}
