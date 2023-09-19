package mdi;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Duration;

public class LibraryManager {
	public static void main(String[] args) {
		Library library = new Library("UTA Library");

		library.addPublication(new Publication("The great Gatsby, by F.Scott Fitzgerald", "Morris Dickstein", 2010));
		library.addPublication(new Publication("Discrete Mathematics with Coding", "Hugo D. Junghenn", 2023));
		library.addPublication(new Publication("The complete book of Turkish cooking", "Ayla Esen Algar", 2009));

		try {
		Video video1 = new Video("Inception", "Christopher Nolan", 2010, 148);
		Video video2 = new Video("Barbie", "Greta Gerwig", 2023, 114);
		Video video3 = new Video("Pulp Fiction", "Quentin Tarantino", 1994, 154);

		library.addPublication(video1);
		library.addPublication(video2);
		library.addPublication(video3);
		} catch (InvalidRuntimeException e) {
			System.out.println("Caught InvalidRuntimeException when adding a video: " + e.getMessage());
		}

		System.out.println(library);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the publicationIndex to check out a book: ");
		int publicationIndex = scanner.nextInt();

		if(publicationIndex >= 0) {
			System.out.print("Enter the your name: ");
			scanner.nextLine();
			String borrowerName = scanner.nextLine();

		try {
			library.checkout(publicationIndex, borrowerName);
			System.out.println("Book checked out successfully.");
		} catch (IndexOutOfBoundsException e) {

			System.out.println("Error: Invalid publicationIndex. ");
		}
	} else {
		System.out.println("Error: Invalid publicationIndex.");
	}

		System.out.println(library);

	}
}