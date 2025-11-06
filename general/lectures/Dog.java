public class Dog extends Mammal {
	public Dog(String name, int age, String furColor) {
		super(name, age, furColor);
	}

	@Override
	public void speak() {
		System.out.println("Woof!");
	}

	public void playFetch() {
		System.out.printf("Played fetch with %s!%n", name);
	}
}
