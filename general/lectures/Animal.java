public abstract class Animal {
	protected String name;
	protected int age;

	public Animal(String name, int age) {
		setName(name);
		setAge(age);
	}

	public abstract void speak();

	public void bathTime() {
		System.out.printf("%s took a bath%n", name);
	}

	public final String getName() {
		return name;
	}

	public final int getAge() {
		return age;
	}

	public final void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		this.name = name;
	}

	public final void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		this.age = age;
	}

	@Override
	public final String toString() {
		return String.format("%s is %d years old", name, age);
	}
}
