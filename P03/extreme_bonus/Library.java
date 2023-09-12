import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	private String name;
	private List<Publication> publications = new ArrayList<>();
	private List<Patron> patrons = new ArrayList<>();

	public Library(String name) {
		this.name = name;
	}

	public void addPublication(Publication publication) {
		publications.add(publication);
	}

	public void addPatron(Patron patron) {
		patrons.add(patron);
	}

	public void checkout(int publicationIndex, int patronIndex) {
		if (publicationIndex >= 0 && publicationIndex < publications.size() && patronIndex >= 0 && patronIndex < patrons.size()) {
			Publication publication = publications.get(publicationIndex);
            Patron patron = patrons.get(patronIndex);
		} else {
			throw new IndexOutOfBoundsException("Invalid publicationIndex");
		}
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public List<Patron> getPatrons() {
        return patrons;
    }

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Library Name: ").append(name).append("\n");
		result.append("Publications:\n");
		for (int i = 0; i < publications.size(); i++) {
            Publication publication = publications.get(i);
            result.append(i).append(": ").append(publication.getTitle());
            Patron loanedTo = publication.getLoanedTo();
            if (loanedTo != null) {
                result.append(" (Loaned to: ").append(loanedTo).append(", Due Date: ").append(publication.getDueDate()).append(")");
            }
            result.append("\n");
        }
        result.append("Patrons:\n");
        for (int i = 0; i < patrons.size(); i++) {
            result.append(i).append(": ").append(patrons.get(i)).append("\n");
        }

		return result.toString();
	}
}