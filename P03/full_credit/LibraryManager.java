import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
	public static void main(String[] args) {
		Library library = new Library("UTA Library");

		library.addPublication(new Publication("The great Gatsby, by F.Scott Fitzgerald", "Morris Dickstein", 2010));
		library.addPublication(new Publication("Discrete Mathematics with Coding", "Hugo D. Junghenn", 2023));
		library.addPublication(new Publication("The complete book of Turkish cooking", "Ayla Esen Algar", 2009));

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