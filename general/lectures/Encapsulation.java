class Encapsulation {
	public static void main(String[] args) {
		// Person p = new Person();
		// The above line would not compile because we defined a constructor that requires parameters.
		// When we define a constructor, the default no-argument constructor can no longer be used.
		// This is intended behavior- since the default constructor would create an invalid object.

		// p.name = "Bob";
		// The above line would not compile because the 'name' field is private.
		// Private fields cannot be accessed directly from outside the class.
		// This ensures that all modifications to its state go through the setter methods,
		// which can enforce our logical validation rules.

		Person p = new Person("Bob", 1294573, 55000);

		// If we did not provide a toString method in the Person class,
		// the below line would print something like "Person@6bc7c054" (the class name and the object's hash code).
		// This is not very useful, so we override the toString method to provide a more meaningful representation.
		// The toString method is called automatically when an object is printed.
		// It would not be incorrect to call it explicitly- System.out.println(p.toString()); is valid.
		// However, it is more idiomatic to let the println method call it implicitly.
		System.out.println(p);

		// If we want to change the state of this object, we must use the setter methods.
		// These enforce logical validation and will throw an exception if the new value is invalid.
		p.setName("Robert");
		p.setSalary(60000);
		System.out.println(p);
		
		// For example, the following lines would throw an IllegalArgumentException.
		// p.setName("");
		// p.setSalary(-100);
	}
}
