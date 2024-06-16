abstract class AbstractGreeter {
	private final String recipient;

	protected AbstractGreater(String recipient) {
		this.recipient = recipient;
	}

	protected void hello() {
		System.out.println("Hello " + recipient + "!");
	}
}

public class WorldGreeter extends AbstractGreeter {
	public WorldGreeter() {
		super("World");
	}

	void test(AbstractGreeter other) {
		this.hello();
		super.hello();
		other.hello();
	}
}

public class test_protected {
	public static void main(String[] args) {

	}
}
