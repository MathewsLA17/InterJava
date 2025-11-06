import java.util.Scanner;

public class EnumsAndSwitch {
	// Suppose we want to represent the days of the week in our program.
	// One option could be to use integer constants, such as 0 for Sunday, 1 for Monday, and so one, like so:
	// int SUNDAY = 0;
	// int MONDAY = 1;
	// ...
	// However, this approach has several drawbacks:
	// 1. Lack of type safety: Since these are just integers, any integer value can be assigned to a variable meant to represent a day.
	// 2. Poor readability: Using integers makes the code less readable and harder to understand.
	// 3. Risk of name collisions: If you have multiple sets of constants, there is a risk of name collisions.
	//
	// Another option would be to simply use strings to represent the days of the week, like so:
	// String today = "THURSDAY";
	// However, this approach also has its drawbacks:
	// 1. Lack of type safety: Any string value can be assigned to a variable meant to represent a day.
	// 2. Risk of typos: Since strings are not checked at compile time, there is a risk of typos leading to bugs.
	// 3. Performance: Comparing strings is generally slower than comparing integers.
	//
	// A better solution is to use an enum (short for "enumeration").
	// Enums provide a way to define a set of named constants that are type-safe and more readable.
	// See the Day enum defined below for an example.

	public static void main(String[] args) {
		// Any custom enum type you declare can be used as a data type in your program.
		// Here we use the Day enum to create a variable called today.
		// Note that we refer to enum constants using the enum type name as a qualifier.
		// This is similar to how we refer to static class members.
		// For example, just writing Day today = THURSDAY; would result in a compile-time error.
		// Enums provide type safety, ensuring that the variable can only hold one of the predefined constants.
		// This helps prevent errors that can occur with using simple constants like integers or strings.
		// Since each enum constant exists within the scope of the enum type, there is no risk of name collisions.
		// For example, if you had another enum with a constant named MONDAY, it would not conflict with Day.MONDAY.
		Day today = Day.THURSDAY;

		// Custom enum types can be used like any other data type, including function parameters and return types.
		// Here we pass the today variable to the tellItLikeItIs() method.
		tellItLikeItIs(today);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a day of the week: ");
		String userInput = input.nextLine().toUpperCase();

		try {
			// The valueOf() method is a static method provided by the Enum class.
			// It takes a string as an argument and returns the corresponding enum constant.
			// If the string does not match any of the enum constants, it throws an IllegalArgumentException.
			// Here we convert the user input string to an enum constant of type Day.
			// Note that the case of the input string must match the case of the enum constants.
			// In this example, we convert the input to uppercase to match the enum constants.
			Day userDay = Day.valueOf(userInput);
			tellItLikeItIs(userDay);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid day entered.");
		}

		input.close();
	}

	// The purpose of this function is to provide a message based on the day of the week.
	private static void tellItLikeItIs(Day day) {
		// We could accomplish this using a series of if-else-if statements, like so:
		// if (day == Day.MONDAY) {
		//     System.out.println("Mondays are bad.");
		// } else if (day == Day.FRIDAY) {
		//     System.out.println("Fridays are better.");
		// } else if (day == Day.SATURDAY || day == Day.SUNDAY) {
		//     System.out.println("Weekends are best.");
		// } else {
		//     System.out.println("Midweek days are so-so.");
		// }
		// However, a more concise and readable way to achieve the same result is by using a switch statement.
		//
		// A switch statement is a control flow statement that allows a variable to be tested for equality against a list of values.
		// Each value is called a case, and the variable being switched on is checked for each case.
		// The switch statement is often used as a more readable alternative to a series of if-else-if statements when dealing with multiple discrete values.
		// In this example, we use a switch statement to provide different messages based on the value of the day parameter.
		// Note that we do not need to qualify the enum constants with the enum type name (Day) inside the switch statement.
		// This is because the switch statement is already aware of the type of the variable being switched on.
		// Each case ends with a break statement to prevent fall-through, which is when the execution continues to the next case even if a match is found.
		// The default case is executed if none of the other cases match.
		switch (day) {
			// Note: The case labels must be constant expressions.
			// This means that you cannot use variables or expressions that are not constant.
			case MONDAY:
				// Switch statements allow for 'fall-through' behavior, where multiple cases can be grouped together.
				// As such, we do not use curly braces to define the scope of each case.
				// Instead, we simply use a break statement to exit the switch once a matching case is found and executed.
				System.out.println("Mondays are bad.");
				break;
			case FRIDAY:
				System.out.println("Fridays are better.");
				break;
			// Here we demonstrate 'fall-through' by grouping multiple cases together.
			// If the day is either SATURDAY or SUNDAY, the same message will be printed.
			case SATURDAY:
			case SUNDAY:
				System.out.println("Weekends are best.");
				break;
			// The default case is optional, but it is good practice to include it to handle unexpected values.
			// If no other case matches, the default case will always be executed.
			// Note that the default case does not need to be the last case in the switch statement.
			// However, it is common practice to place it at the end for better readability.
			default:
				System.out.println("Midweek days are so-so.");
				break;
		}
	}
}

// Enums are a special data type that enables for a variable to be a set of predefined constants.
// The variable must be equal to one of the values that have been predefined for it.
// Common examples include days of the week, months of the year, directions, etc.
//
// Typically, enum declarations should be done in their own file (Day.java, in this case).
enum Day {
	// Enum constants are typically defined in all uppercase letters.
	// By convention, they are separated by commas.
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
}