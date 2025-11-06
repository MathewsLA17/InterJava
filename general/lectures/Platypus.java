public final class Platypus extends Monotreme {
	public Platypus(String name, int age) {
		super(name, age, "Brown");
	}

	@Override
	public void speak() {
		System.out.println("Quack?");
	}
}
