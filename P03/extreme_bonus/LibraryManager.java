import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
	public static void main(String[] args) {
		Library library = new Library("UTA Library");

		try (BufferedReader reader = new BufferedReader(new FileReader("library_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String type = parts[0].trim();
                    if ("Publication".equals(type) && parts.length == 4) {
                        String title = parts[1].trim();
                        String author = parts[2].trim();
                        int copyright = Integer.parseInt(parts[3].trim());
                        library.addPublication(new Publication(title, author, copyright));
                    } else if ("Patron".equals(type) && parts.length == 2) {
                        String name = parts[1].trim();
                        library.addPatron(new Patron(name));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading data from the file: " + e.getMessage());
        }

        System.out.println("Available Publications:");
        for (int i = 0; i < library.getPublications().size(); i++) {
            System.out.println(i + ": " + library.getPublications().get(i).getTitle());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the publicationIndex to check out a book: ");
        int publicationIndex = scanner.nextInt();

         System.out.println("\nAvailable Patrons:");
        for (int i = 0; i < library.getPatrons().size(); i++) {
            System.out.println(i + ": " + library.getPatrons().get(i));
        }

         System.out.print("Enter the patronIndex who is checking out: ");
        int patronIndex = scanner.nextInt();

        if (publicationIndex >= 0 && publicationIndex < library.getPublications().size() &&
            patronIndex >= 0 && patronIndex < library.getPatrons().size()) {
            library.checkout(publicationIndex, patronIndex);
            System.out.println("Successful checkout!");
        } else {
            System.out.println("Error: Invalid publicationIndex or patronIndex.");
        }

        System.out.println("\nLibrary Status:");
        System.out.println(library);
	}
}
