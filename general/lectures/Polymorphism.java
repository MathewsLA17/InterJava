public class Polymorphism {
	public static void main(String[] args) {
		// Since Dogs and Cats are both Animals, we can store them in an array of Animals.
		// This is called polymorphism.
		// Polymorphism is the ability to treat objects of different types as if they were the same type.
		// We don't have to cast Dogs or Cats into Animals since they're already Animals.
		// This is called implicit upcasting.
		// Implicit means that it happens automatically.
		// Upcasting means that we're casting from a more specific type to a more general type.
		// This can be safely implicit because all Dogs and Cats are Animals.
		Animal[] animals = {
				new Cat("Oliver", 17),
				new Dog("Abbey", 16),
				new Cat("Pepper", 6),
				new Dog("Koro", 5),
				new Cat("Mewlie", 13),
				new Dog("Cerberus", 3),
		};

		for (int i = 0; i < animals.length; i++) {
			// The Animal class defines a toString() method, so all child classes of Animal inherit it.
			System.out.println(animals[i]);

			// The Speak() method is defined in the Animal class, but it's overridden in the Dog and Cat classes.
			// Animal does not define a body for Speak(), so it's an abstract method.
			// This means that we can't create an Animal object, only child classes of Animal.
			// We know that all Animals can Speak(), but all Animals Speak() differently.
			animals[i].speak();

			System.out.println("Bath time!");

			// The BathTime() method is defined in the Animal class, but it's overridden in the Cat class.
			// Animal defines a body for bathTime(), so it's not an abstract method.
			animals[i].bathTime();

			System.out.printf("Hey %s, want to play fetch?%n", animals[i].getName());

			// It would be a bad idea to cast all Animals to Dogs and call playFetch() on them.
			// A valid conversion from Animal -> Dog exists, so this is allowed- but only explicitly.
			// For example, the following code would not compile:
			// Dog d = animals[i];
			// This would be an 'implicit downcast' which is not allowed in Java. It would be unsafe.
			// An explicit downcast could be done like so:
			// Dog d = (Dog)animals[i];
			// However, this could throw a ClassCastException if the Animal is not actually a Dog.
			// We can explicitly downcast an Animal to a Dog, but only if the Animal is actually a Dog.
			// This is called a 'type check' or 'type test'.
			if (animals[i] instanceof Dog) {
				Dog d = (Dog) animals[i];
				d.playFetch();
			} else {
				System.out.printf("No thanks, %s doesn't like fetch.%n", animals[i].getName());
			}

			// Note that while it is possible to catch a ClassCastException, it is not recommended.
			// This is because it is a sign that your code is not structured correctly.
			// It is better to use a type check to ensure that the cast is valid.
			// This is called 'defensive programming'.
		}
	}
}