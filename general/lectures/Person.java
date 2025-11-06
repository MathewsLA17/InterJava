class Person {
	// To ensure proper encapsulation, all fields should be private.
	// This prevents them from being accessed directly from outside the class.
	// Direct access would allow other classes to:
	// 1. Read fields that we might not want to expose.
	// 2. Modify fields in ways that could lead to invalid states.
	// Objects should always be in a valid state.
	// To enforce this, we selectively expose fields through public 'getter' and 'setter' methods.
	private String name;
	private int id;
	private double salary;

	// This is a constructor.
	// Constructors are special methods that are called when an object is created.
	// Unlike normal methods, they do not have a return type and their name must match the class name.
	// They still have a parameter list and a body.
	// Constructors are typically used to initialize the fields of an object.
	//
	// In our program, we require a name, id, and salary in order to create a Person object.
	// As such, we define a constructor that takes these values as parameters.
	// Note that these parameters are local to the constructor and do not conflict with the fields of the same name.
	// Importantly, just having these parameters does not automatically set the fields.
	// This is a common mistake made by beginners.
	// We must explicitly assign the parameter values to the fields if we want to store them.
	public Person(String name, int id, double salary) {
		// Remember- objects must always be in a valid state.
		// If the caller attempted to construct a Person with invalid values, we should throw an exception.
		// If a constructor throws an exception, the object is not created.
		// This is preferable to creating an object in an invalid state.

		// Rather than re-write the validation logic in the constructor,
		// we can leverage the existing setter methods to perform the validation.
		// This is a common technique to avoid code duplication.
		// Remember the DRY principle- Don't Repeat Yourself.
		setName(name);

		// We wanted the ID to be a read-only value.
		// As such, we did not provide a setter method for it.
		// The only place to set it is in the constructor.
		// So, we have to validate it here.
		if (id < 1000000 || id > 9999999) {
			throw new IllegalArgumentException("ID must be a 7-digit number.");
		}
		this.id = id;

		setSalary(salary);
	}

	// To expose a field for reading, we provide a public 'getter' method.
	// By convention, the method is named 'getFieldName'.
	// The method is public so it can be accessed from outside the class.
	// Note that there is nothing inherently special about getter methods.
	// They are just normal methods that follow an established convention.
	// Since this method is encapsulating the 'name' field,
	// It must return a String, the type of the 'name' field.
	// It does not require any parameters, since it is simply returning the value of the field.
	//
	// Since the encapsulated name field is private, it cannot be accessed directly from outside the class.
	// So if we wanted to prevent read access to the name field, we would simply not provide a getter method.
	public String getName() {
		// The job of a getter method is to return the value of the field.
		// Nothing more, nothing less.
		return name;
	}

	// To expose a field for writing, we provide a public 'setter' method.
	// By convention, the method is named 'setFieldName'.
	// The method is public so it can be accessed from outside the class.
	// Just as with getter methods, there is nothing inherently special about setter methods.
	// They are just normal methods that follow an established convention.
	// The job of a setter method is to set the value of the field.
	// It shouldn't return anything, so its return type is void.
	// It requires a parameter of the same type as the field, since that is the value we want to set.
	// In this case, we want to set the 'name' field, which is a String.
	// The name of the parameter should match the field name, but it is not required.
	// Typically, you should "call it what it is" to avoid confusion with other developers or your future self.
	// 
	// Since the encapsulated name field is private, it cannot be accessed directly from outside the class.
	// So if we wanted to prevent write access to the name field, we would simply not provide a setter method.
	// This is how we can create read-only fields (assuming we provide a getter method).
	// If we wanted to create write-only fields, we would provide a setter method but not a getter method.
	// Write-only fields are rare, but they can be useful for sensitive information like passwords.
	public void setName(String name) {
		// Remember- objects should always be in a valid state.
		// If the caller attempted to set an invalid value, we should throw an exception.
		if (name == null || name.isBlank()) {
			// IllegalArgumentException is a common exception to throw for invalid arguments.
			// It is an unchecked exception, so we do not need to declare it in the method signature.
			// Why not just 'return' and end the method?
			// Because we want to signal to the caller that something went wrong.
			// Why not print an error message?
			// Because printing is not the job of this method,
			// and the caller may not even be monitoring the console.
			// Throwing an exception is the standard way to signal an error in Java.
			// Do not use print statements or error codes in an Exception-based language like Java.
			//
			// The message provided to the exception should be clear and descriptive.
			// It should help the caller understand what went wrong and how to fix it.
			// Don't be afraid to use technical language, as this is intended for developers.
			// Avoid vague messages like "Invalid input" or "Error occurred".
			throw new IllegalArgumentException("Name cannot be null or blank.");
		}

		// If we reach this point, the name is valid.
		// Why don't we need an 'else' block?
		// Because if the name is invalid, an exception is thrown and the method exits immediately.
		// Java is a 'fail-fast' language.
		// This means that errors should be caught and reported as soon as possible.
		// This makes it easier to identify and fix problems.
		//
		// The 'this' keyword is a reference to the current object.
		// It is used to distinguish between the field and the parameter, which have the same name.
		// If we omitted 'this', we would be assigning the parameter to itself, which does nothing.
		this.name = name;
	}

	// We wanted the ID to be a read-only value.
	// As such, we did not provide a setter method for it.
	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("Salary cannot be negative.");
		}

		this.salary = salary;
	}

	// The toString method is a special method that is called when an object is printed.
	// It is also called when an object is concatenated with a String.
	// It must have the exact signature shown below, and the @Override annotation is required.
	@Override
	public String toString() {
		// The job of the toString method is to return a String representation of the object.
		// It should NEVER print anything- that is not its job.
		// The returned String should be clear and descriptive.
		// It should include the values of the important fields of the object.
		// This makes it easier to understand the state of the object when it is printed.
		// The format of the String is up to you, but it should be consistent and easy to read.
		return String.format("Name: %s, ID: %d, Salary: $%.2f", name, id, salary);
	}
}
