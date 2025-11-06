
public class Generics {
	public static void main(String[] args) {
		Dog dog = new Dog("Koro", 3, "White");
		Cat cat = new Cat("Mona", 5, "Black");
		Bird bird = new Bird("Sunny", 1);
		Platypus platypus = new Platypus("Bill", 4);
		int[] a1 = { 1, 2, 3, 4, 5 };
		double[] a2 = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		String[] a3 = { "one", "two", "three", "four", "five" };
		Animal[] a4 = { dog, cat, bird, platypus };

		print(a1);
		print(a2);
		print(a3);
		print(a4);

		Container<Integer> c1 = new Container<Integer>(1);
		System.out.println(c1.getValue());
		c1.setValue(2);
		System.out.println(c1.getValue());

		Container<Double> c2 = new Container<Double>(1.1);
		System.out.println(c2.getValue());
		c2.setValue(2.2);
		System.out.println(c2.getValue());

		Container<String> c3 = new Container<String>("hello");
		System.out.println(c3.getValue());
		c3.setValue("world");
		System.out.println(c3.getValue());

		Barn<Animal> barnForAnyone = new Barn<Animal>();
		barnForAnyone.setValue(dog);
		barnForAnyone.visit();
		barnForAnyone.setValue(cat);
		barnForAnyone.visit();
		barnForAnyone.setValue(bird);
		barnForAnyone.visit();
		barnForAnyone.setValue(platypus);
		barnForAnyone.visit();

		Barn<Mammal> barnForMammals = new Barn<Mammal>();
		barnForMammals.setValue(dog);
		barnForMammals.visit();
		barnForMammals.setValue(cat);
		barnForMammals.visit();
		barnForMammals.setValue(platypus);
		barnForMammals.visit();
	}

	
	private static <T> void print(T[] array) {
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}
}


class Container<T> {
	protected T value;

	public Container(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}

class Barn<T extends Animal> extends Container<T> {
	public Barn(T value) {
		super(value);
	}

	public void visit() {
		System.out.printf("Visiting %s...%n", value.getName());
		value.speak();
	}
}