public class Semantics {
	public static void main(String[] args) {
		// All eight primitive types in Java are stored on the stack and have value semantics.
		// The 'stack' is a region of memory that stores temporary variables created by each function (including the main function).
		// It is very fast to allocate and deallocate memory on the stack.
		// However, the stack is limited in size and cannot store large amounts of data.
		// Additionally, primitive types hold their actual values, not references to values.
		// For example, if we store the value 4 in an int variable, the variable directly contains the value 4.
		// Under the hood, we'll store the value in binary format, which is how computers represent data.
		// So in practice, we'd store the following 32-bit binary value for the int 4:
		// 00000000 00000000 00000000 00000100
		// When we copy the value of a primitive type, we copy the actual value, not a reference to it.
		// This is known as value semantics.
		int a = 4;
		int b = a; // b will get a copy of the value in a
		System.out.println("a = " + a + ", b = " + b); // a and b are both 4
		b = 5; // b will now be 5
		System.out.println("a = " + a + ", b = " + b); // a is still 4, b is now 5

		// All non-primitive types in Java are stored on the heap and have reference semantics.
		// The 'heap' is a region of memory that stores objects created by the program.
		// It is larger than the stack and can store large amounts of data.
		// However, it is slower to allocate and deallocate memory on the heap.
		// Additionally, non-primitive types hold references (or pointers) to the actual values stored in the heap.
		// For example, if we create a Wrapper object that holds the value 4,
		// the variable will contain a reference to the location in memory where the Wrapper object is stored.
		// When we copy the reference of a non-primitive type, we copy the reference, not the actual value.
		// This is known as reference semantics.
		// So if we have two variables that reference the same object, changes made through one variable will be reflected in the other.
		// This is because both variables point to the same location in memory.
		Wrapper w1 = new Wrapper(4);
		Wrapper w2 = w1; // w2 will get a copy of the reference in w1, they are pointing to the same object
		System.out.println("\nw1.x = " + w1.x + ", w2.x = " + w2.x); // w1.x and w2.x are both 4
		w2.x = 5; // w2.x will now be 5- and remember that w1 and w2 point to the same object
		System.out.println("w1.x = " + w1.x + ", w2.x = " + w2.x); // w1.x is now 5, because w1 and w2 point to the same object

		// Value semantics and reference semantics also apply to method parameters.
		// If we pass a primitive type to a method, we pass a copy of the value (value semantics).
		// Any changes made to the parameter inside the method will not affect the original variable.
		int x = 44;
		System.out.println("\nBefore valueSemantics, x = " + x);
		valueSemantics(x);
		System.out.println("After valueSemantics, x = " + x);

		// If we pass a non-primitive type to a method, we pass a copy of the reference (reference semantics).
		// This is not the same as 'pass by reference', which is a different concept not used in Java.
		// Any changes made to the object through the parameter inside the method will affect the original object.
		Wrapper w3 = new Wrapper(44);
		System.out.println("\nBefore referenceSemantics, w3.x = " + w3.x);
		referenceSemantics(w3);
		System.out.println("After referenceSemantics, w.x = " + w3.x);

		// However, Java is always pass by value. Don't be confused by the reference semantics of non-primitive types.
		// When we pass a non-primitive type to a method, we pass a copy of the reference (value semantics).
		// Any changes made to the parameter inside the method will not affect the original reference.
		// (Importantly- changes made to the PARAMETER itself, not the object it points to.)
		// This is because we are changing what the parameter points to, not the original reference.
		// This is a subtle but important distinction.
		//
		// Consider this analogy with real-world addresses:
		// - You live in a house (the object).
		// - Your address (the reference) tells people where to find your house.
		// - Suppose someone asks where you live, you would give them your address, not the house itself.
		// - Let's say you write your address on a piece of paper and hand it to a friend (passing the reference by value).
		// - Your friend now has a copy of your address (a copy of the reference).
		// - If your friend decides to change the address on the paper to a different address (changing the parameter),
		//   it doesn't change where you actually live (the original reference still points to your house).
		Wrapper w4 = new Wrapper(44);
		System.out.println("\nBefore javaIsAlwaysPassByValue, w4.x = " + w4.x);
		javaIsAlwaysPassByValue(w4);
		System.out.println("After javaIsAlwaysPassByValue, w4.x = " + w4.x);

		// Why does this matter?
		// Understanding value semantics and reference semantics is crucial for writing correct and efficient code.
		// Primitive types are small, the largest are only 64 bits (8 bytes), so they are cheap to copy.
		// Non-primitive types can be arbitrarily large, so copying them can be expensive.
		// For example, you could have an array with millions of elements, or a class with hundreds of fields.
		// Copying such large objects would be inefficient and slow.
		// Instead, we copy a reference (which is typically 32 or 64 bits, depending on the architecture),
		// which is much cheaper and faster.
		// Additionally, understanding how method parameters work is important for avoiding unintended side effects.
		// If you pass a primitive type to a method, you can be sure that the original variable will not be changed.
		// However, if you pass a non-primitive type to a method, you need to be careful about modifying the object,
		// as it will affect the original object.
	}

	private static void valueSemantics(int x) {
		System.out.println("Inside of valueSemantics, x = " + x);
		x = 99;
		System.out.println("Inside of valueSemantics, x = " + x);
		// Since x is a copy of the original value, changing it here does not affect the original variable.
	}

	private static void referenceSemantics(Wrapper w) {
		System.out.println("Inside of referenceSemantics, w.x = " + w.x);
		w.x = 99;
		System.out.println("Inside of referenceSemantics, w.x = " + w.x);
		// Since w is a copy of the original reference, changing the object it points to here does affect the original object.
	}

	private static void javaIsAlwaysPassByValue(Wrapper w) {
		System.out.println("Inside of javaIsAlwaysPassByValue, w.x = " + w.x);
		w = new Wrapper(99);
		System.out.println("Inside of javaIsAlwaysPassByValue, w.x = " + w.x);
		// Since w is a copy of the original reference, changing what w points to here does not affect the original reference.
	}
}

// A simple wrapper class to demonstrate reference semantics.
// This class is not useful in practice, but it helps illustrate the concept.
// Also, writing a class in the same file as another is not idiomatic Java,
// but it is done here for simplicity and to keep everything in one place.
class Wrapper {
	// Public fields are also bad practice, but this is just for demonstration purposes.
	public int x;

	public Wrapper(int x) {
		this.x = x;
	}
}
