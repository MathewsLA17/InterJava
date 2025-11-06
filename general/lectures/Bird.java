public class Bird extends Animal implements EggLayer {
	public Bird(String name, int age) {
		super(name, age);
	}

	@Override
	public void speak() {
		System.out.println("Tweet!");
	}

	@Override
	public final void layEgg() {
		System.out.printf("%s laid an egg!%n", name);
	}
}
