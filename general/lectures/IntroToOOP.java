// public class IntroToOOP {
// 	public static void main(String[] args) {
// 		// The following three lines of code represent an attempt to store
// 		// information about a single person. However, there are several flaws with this approach. 
// 		// String name = "Charlie";
// 		// int id = 3456789;
// 		// double salary = 60000;
// 		//
// 		// 1. It is not clear that these three variables are related to each other.
// 		// 2. If we want to store information about another person, we need to create three more variables.
// 		// 3. If we wanted to pass all of the information about a person to a method, we would need to pass three separate parameters.
// 		// 4. These variables will be scattered throughout memory, giving poor locality of reference.
// 		// Several additional flaws exist that will be discussed later.

// 		// Alternatively, we could try to use arrays to remedy some of these issues.
// 		// String[] names = new String[2];
// 		// int[] ids = new int[2];
// 		// double[] salaries = new double[2];
// 		//
// 		// This methodology is known as parallel arrays. It solves some of the issues mentioned above, but it still has several flaws.
// 		// The ideal solution would be to group all of the information about a person into a single unit...
// 		// This is known as an object, and the blueprint for creating such objects is known as a class.
// 		// See the Person.java file for the definition of the Person class.

// 		// Once we have defined a class, it becomes a valid type in Java, just like int, double, String, etc.
// 		// For example, you could declare a variable like so:
// 		// Person p;
// 		// However, this does not actually create a Person object. It only creates a variable that can refer to a Person object.
// 		// All objects in Java are reference types, meaning that the variable stores a reference (or address) to the actual object in memory.
// 		// On an x64 system, this reference is typically 8 bytes (64 bits) in size.
// 		// No matter how large the object itself is, the reference will always be the same size.

// 		// To actually create a Person object, we use the new keyword, which allocates memory for the object on the heap.
// 		// Whenever we see the 'new' keyword, we know that memory is being allocated.
// 		// The process of creating a new object is known as instantiation.
// 		Person alice = new Person();

// 		// Now that we have a Person object, we can access its fields using the dot operator.
// 		// Each object has its own copy of each field defined in the class.
// 		// Though multiple objects of the same class might share the same field names, they are completely independent of each other.
// 		alice.name = "Alice";
// 		alice.id = 1234567;
// 		alice.salary = 55000;

// 		// If we instantiate another Person object, it will have its own independent fields.
// 		Person bob = new Person();
// 		bob.name = "Bob";
// 		bob.id = 9876543;
// 		bob.salary = 40000;

// 		// Notice how both alice and bob have their own copies of the fields defined in the Person class.
// 		System.out.println(alice.name);
// 		System.out.println(alice.id);
// 		System.out.println(alice.salary);

// 		System.out.println(bob.name);
// 		System.out.println(bob.id);
// 		System.out.println(bob.salary);

// 		// Here we pass the alice object to the giveRaise method.
// 		// Note that we are passing a reference to the object, not a copy of the object itself.
// 		// Any changes made to the object inside the method will be reflected outside the method as well.
// 		// This is because both the caller and the callee are referring to the same object in memory.
// 		// This is different from primitive types (int, double, etc.), which are passed by value (a copy is made).
// 		giveRaise(alice);
// 		System.out.printf("%s's salary is now %.2f%n", alice.name, alice.salary);

// 		// Here we demonstrate that multiple references can refer to the same object.
// 		// This is similar to having two different variables that store the same memory address.
// 		// Note that no new object is created here. We are simply creating a new reference to the existing object.
// 		// Importantly- this does not create a new copy of the object. There is still only one object in memory.
// 		// Therefore, changes made to the object through one reference will be visible through the other reference as well.
// 		Person example = bob;
// 		bob.name = "Edward";
// 		System.out.println(bob.name);
// 		System.out.println(example.name);
// 	}

// 	// This method gives a 10% raise to the salary of the Person object passed to it.
// 	// Since objects use reference semantics, any changes made to the object inside this method will be visible outside the method as well.
// 	private static void giveRaise(Person p) {
// 		p.salary *= 1.1;
// 	}
// }
