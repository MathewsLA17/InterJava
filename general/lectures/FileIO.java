import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileIO {
	private static void fileWritingDemo() {
		String path = "test.txt";
		File file = new File(path);

		if (file.exists() && file.canWrite()) {
			System.out.println("File exists and is writable.");
		} else {
			System.out.println("File does not exist or is not writable.");
		}

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, false));

			writer.write("Hello, World!");
			writer.newLine();
			writer.write("This is a test file.");
		} catch (IOException e) {
			System.out.println("Could write to file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("Could not close writer: " + e.getMessage());
			}
		}
	}

	private static void fileReadingDemo() {
		try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not read file: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		fileWritingDemo();
		fileReadingDemo();
	}
}
