package library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	private String name;
	private List<Publication> publications = new ArrayList<>();

	public Library(String name) {
		this.name = name;
	}

	public void addPublication(Publication publication) {
		publications.add(publication);
	}

	public void checkout(int publicationIndex, String patron) {
		if (publicationIndex >= 0 && publicationIndex < publications.size()) {
			publications.get(publicationIndex).checkOut(patron);
		} else {
			throw new IndexOutOfBoundsException("Invalid publicationIndex");
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Library Name: ").append(name).append("\n");
		result.append("Publications:\n");
		for (int i = 0; i < publications.size(); i++) {
			result.append(i).append(": ").append(publications.get(i)).append("\n");
		}

		return result.toString();
	}
}