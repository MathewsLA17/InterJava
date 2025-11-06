import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileIOPart2 {
	private static int getLineCount(String path) throws IOException {
		File file = new File(path);
		int lineCount = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while (reader.readLine() != null) {
				lineCount++;
			}
		} catch (IOException e) {
			throw e;
		}

		return lineCount;
	}

	private static Album[] readAlbumsFromFile(String path) throws IOException {
		int numAlbums = getLineCount(path) - 1;
		Album[] albums = new Album[numAlbums];

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line = reader.readLine();

			for (int i = 0; i < numAlbums; i++) {
				line = reader.readLine();
				String[] columns = line.split(",");

				int rank = Integer.parseInt(columns[0].trim());
				int year = Integer.parseInt(columns[1].trim());
				String title = columns[2].trim();
				String artist = columns[3].trim();
				String genre = columns[4].trim();

				albums[i] = new Album(title, artist, rank, year, genre);
			}
		} catch (IOException e) {
			throw e;
		}

		return albums;
	}

	private static void writeAlbumToFile(Album album, String path) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
			String line = String.format("%d,%d,%s,%s,%s\n", album.getRank(), album.getYear(), album.getTitle(),
					album.getArtist(), album.getGenre());

			writer.write(line);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		String filePath = "Rolling-Stone-Top-500-Albums.csv";

		Album[] albums = null;
		try {
			albums = readAlbumsFromFile(filePath);
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
			return;
		} catch (NumberFormatException e) {
			System.out.println("Error parsing number: " + e.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			return;
		}

		if (albums != null) {
			System.out.printf("Top %d Albums:\n", albums.length);
			for (int i = 0; i < albums.length; i++) {
				System.out.println(albums[i]);
			}
		}
	}
}

class Album {
	private String title;
	private String artist;
	private int rank;
	private int year;
	private String genre;

	public Album(String title, String artist, int rank, int year, String genre) {
		this.title = title;
		this.artist = artist;
		this.rank = rank;
		this.year = year;
		this.genre = genre;
	}

	public int getRank() {
		return rank;
	}

	public String getGenre() {
		return genre;
	}

	public String getArtist() {
		return artist;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return String.format("#%d: %s by %s (%d) [%s]", rank, title, artist, year, genre);
	}
}
