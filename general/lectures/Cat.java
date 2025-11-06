public final class Cat extends Mammal {
	public Cat(String name, int age, String furColor) {
		super(name, age, furColor);
	}

	@Override
	public void bathTime() {
		System.out.printf("%s hates baths and ran away!%n", name);
	}

	@Override
	public void speak() {
		System.out.println("Meow!");
	}
}
