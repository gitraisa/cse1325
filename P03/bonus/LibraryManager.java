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

		library.addPatron(new Patron("Raisa Tasnim"));
		library.addPatron(new Patron("Isaac Ramirez"));

		System.out.println(library);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the publicationIndex to check out a book: ");
		int publicationIndex = scanner.nextInt();

		System.out.println("Select a patron for checking out the book:");
        int patronIndex = scanner.nextInt();

		
		try {
			library.checkout(publicationIndex, patronIndex);
			System.out.println("Book checked out successfully.");
		} catch (IndexOutOfBoundsException e) {

			System.out.println("Error: Invalid publicationIndex or patronIndex. ");
		}

		System.out.println(library);
	}
}
