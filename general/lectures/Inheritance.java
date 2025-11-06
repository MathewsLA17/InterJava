public class Inheritance {
	public static void main(String[] args) {
		// Dog and Cat are normal classes- we can use them just like any other class.
		Dog koro = new Dog("Koro", 5);
		Cat mona = new Cat("Mona", 7);

		// We can also use the base class, Animal, to refer to instances of Dog and Cat.
		// This is called 'polymorphism'.
		// We can use the same variable to refer to different types of objects.
		// This is useful because it allows us to write code that can work with any type of Animal.
		// However, by storing a Dog or Cat in an Animal variable, we lose access to the Dog/Cat-specific methods.
		Animal mewlie = new Cat("Mewlie", 12);

		// More polymorphism examples:
		Animal a1 = koro;
		Animal a2 = mona;

		// We can call the speak() method on any Animal, even though it is not defined in the base class.
		a1.speak();
		a2.speak();

		// However, we cannot playFetch() with Animals- only Dogs.
		// If you tried to call playFetch() on a1 or a2, it would not compile.
		koro.playFetch();

		// Notice now all Animal objects use the same toString() in the resulting printout.
		// This is because they inherited their toString() definition from Animal.
		System.out.println(koro);
		System.out.println(mona);
		System.out.println(mewlie);
	}
}