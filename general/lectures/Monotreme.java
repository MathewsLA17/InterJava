public abstract class Monotreme extends Mammal implements EggLayer {
	public Monotreme(String name, int age, String furColor) {
		super(name, age, furColor);
	}

	@Override
	public void layEgg() {
		System.out.printf("%s despite being a mammal, laid an egg!%n", name);
	}
}
