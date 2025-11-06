public class Arrays {
	public static void main(String[] args) {
		// An array is a collection of items.
		// It's a contiguous block of memory that holds a fixed number of items.
		// The block of memory exists at a given address in memory.
		// The items in the array are stored in consecutive memory locations.
		// Since Java is a statically typed language, the subdivision of memory is easy.
		// For example, suppose I declare an array of integers (32-bit) with 5 elements.
		// The OS will find a contiguous block of memory that is 5 * 4 (20) bytes long.
		// The resulting address will be the address of the first element in the array.
		// When we access the array, the compiler will calculate the address of the element.
		// The address of the element is calculated as follows:
		// address of the first element + (index * size of the data type).
		// Of course, this is handled by the compiler, so you don't have to worry about it.
		// If you want a more thorough breakdown:
		// Suppose the array was allocated at address 0x1000.
		// The first element would be at 0x1000, the second at 0x1004, the third at 0x1008, and so on.
		// The address of the ith element would be 0x1000 + (i * 4).
		// Notice that the first element is at the base address of the array.
		// This is because no memory is wasted before the first element.
		// As such, we start counting from 0, otherwise known as "zero-based indexing".
		//
		// The syntax for declaring an array is as follows:
		// <data type>[] <name>;
		// This does not allocate memory for the array, it only declares a reference to an array.
		// A reference is just a memory address.
		// Therefore, *any* array of <data type> could be assigned to the reference.
		// On an x64 machine, the size of a reference is 8 bytes.
		// It is significantly more efficient to pass a reference to an array than the entire array.
		// Consider the 5-integer array from earlier.
		// The size of the array would be 20 bytes, but the reference would be 8 bytes.
		// This is especially important when passing arrays to functions.
		// Any changes made to the array in the function will be reflected in the original array.
		//
		// The syntax for initializing an array is as follows:
		// <data type>[] <name> = new <data type>[<size>];
		// This allocates memory for the array.
		// The total size of the array is <size> * sizeof(<data type>).
		// But remember, the size of the reference (<name>) is just 8 bytes (on an x64 machine).

		// Declare an array of integers.
		int[] numbers;

		// Initialize an array of integers with 5 elements.
		// Note that the declaration and initialization can be done in one line.
		// int[] numbers = new int[5];
		// Separating the declaration and initialization was only done for demonstration purposes.
		numbers = new int[5];

		// To access elements of an array, we use the index operator [].
		// The syntax for accessing individual elements is as follows:
		// <name>[<index>]
		// Regardless of the array's type, the index must be an integer.
		// The index must be within the bounds of the array.
		// Accessing out-of-bounds indices will result in an ArrayIndexOutOfBoundsException at runtime.
		// The index is zero-based, so the first element is at index 0.
		// The last element is at index <size> - 1.
		// As such, an array of length N will have indices from 0 to N - 1.
		// We can 'get' or 'set' elements of an array using the index operator.
		// The 'get' operation retrieves the value at the specified index.
		// The 'set' operation assigns a value to the specified index.
		// The syntax for the 'set' operation is as follows:
		// <name>[<index>] = <value>
		// The type of <value> must be the same as the type of the array.

		// Set some example values.
		numbers[0] = 10;
		numbers[1] = 20;
		numbers[2] = 30;
		numbers[3] = 40;

		// Print the values.
		System.out.println(numbers[0]); // 10
		System.out.println(numbers[1]); // 20
		System.out.println(numbers[2]); // 30
		System.out.println(numbers[3]); // 40
		System.out.println(numbers[4]); // 0 (default value for int)

		// We can get the length of the array using the 'length' property.
		// Note that 'length' is a property, not a method, so we don't use parentheses.
		// The length of the array is fixed and cannot be changed after initialization.
		// Attempting to change the length will result in a compilation error.
		System.out.println(numbers.length);

		// We can also initialize an array with values at the time of declaration.
		// The syntax for this is as follows:
		// <data type>[] <name> = { <value1>, <value2>, ..., <valueN> };
		// The size of the array is determined by the number of values provided.
		// The values must be of the same type as the array.
		String[] names = { "Alice", "Bob", "Charlie" };

		// Iterating through an array is often accomplished using a loop.
		// Java provides several types of loops, but the most common are the 'for' loop and the 'while' loop.
		// Here, we'll demonstrate both types of loops to iterate through the 'names' array.
		int index = 0;

		// The 'while' loop continues as long as the condition is true.
		// In this case, we loop while 'index' is less than the length of the array.
		// Inside the loop, we print the current element and increment 'index' by 1.
		// Importantly, the condition is checked before each iteration.
		// If the condition is false at the start, the loop body will not execute at all.
		// Otherwise, the entire loop body will execute once before the condition is checked again.
		// As such, it is important to ensure that the loop will eventually terminate.
		// Failure to do so will result in an infinite loop.
		while (index < names.length) {
			System.out.println(names[index]);
			index++;
		}

		// The pattern we see above is common enough that Java provides a more concise way to write it.
		// The 'for' loop is often used when the number of iterations is known beforehand.
		// The syntax for the 'for' loop is as follows:
		// for (initialization; condition; update) {
		//     // loop body
		// }
		// The 'initialization' step is always executed once (and only once) at the beginning of the loop.
		// It is often used to declare and initialize the loop variable.
		// The 'condition' is checked before each iteration of the loop.
		// Just as with the 'while' loop, if the condition is false at the start, the loop body will not execute at all.
		// The 'update' step is executed at the end of each iteration.
		// It is often used to increment or decrement the loop variable.
		//
		// All three parts of a 'for' loop are optional.
		// For example, we could write an infinite loop as follows:
		// for (;;) { }
		// This is sometimes referred to as a "forever loop".
		//
		// Both while and for loops are interchangeable.
		// Any while loop can be rewritten as a for loop, and vice versa.
		// However, for loops are often more concise and easier to read when the number of iterations is known.
		// Meanwhile, while loops are more suited for situations where the number of iterations is not known beforehand.
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}

		// Here we demonstrate that arrays are passed by reference.
		// Remember that arrays are objects in Java, and objects are always passed by reference.
		// This means that an array is nothing more than a reference to a block of memory.
		// When we pass an array to a function, we are passing the reference to the array.
		// Any modifications made to the array in the function will be reflected in the original array.
		// This is different from primitive types (int, char, etc.), which are passed by value.
		System.out.println("Before modification:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();

		// Pass the array to the function. This function will modify the array.
		modify(numbers);

		// After the function call, we can see that the original array has been modified.
		System.out.println("After modification:");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();

		// Since arrays are objects, assigning one array to another copies the reference.
		// This means that both references point to the same array in memory.
		// Importantly, this does not create a new array (note the lack of 'new' keyword).
		// Therefore, modifying the array through one reference will affect the other reference.
		int[] other = numbers;
		other[0] = 99;
		System.out.println("After modifying 'other':");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();

		// Arrays are themselves a type, and we can have an array of (almost) any type.
		// Here, we create an array of arrays of integers, also known as a 2D array.
		// This can be thought of as a matrix or a grid.
		// Each element of the outer array is itself an array (which is a reference).
		// The syntax for declaring and initializing a 2D array is as follows:
		// <data type>[][] <name> = new <data type>[<rows>][<columns>];
		// The same can apply to higher dimensions, such as 3D arrays.
		// However, higher-dimensional arrays are rarely used in practice.
		// Typically, 2D arrays are only used for data which is naturally represented in two dimensions.
		// Examples include matrices (math), grids (games), and images (pixels).
		int[][] matrix = new int[3][4];
		matrix[0][0] = 1;
		matrix[1][2] = 5;
		matrix[2][3] = 9;
		System.out.println("Matrix:");
		// The outer loop is iterating over the rows of the matrix.
		// Each row is itself an array, so we can access its length using matrix[i].length.
		for (int i = 0; i < matrix.length; i++) {
			// The inner loop is iterating over the columns of the current row.
			// We print each element in the row, followed by a space.
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// This function takes an array of integers and modifies it.
	// Specifically, it doubles each element in the array.
	// Since arrays are objects and are passed by reference, the modifications will be reflected in the original array.
	private static void modify(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= 2;
		}
	}
}
