/**
 * Represents a publication in the library.
 * This class provides information about a publication, including its title, author, copyright year, and loan status.
 * It allows for checking out and returning publications to track their availability.
 * */
package library;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Publication {
	/**
	 * The title of the publication.
	 */
	private String title;
	/**
	 * The author of the publication.
	 */
	private String author;
	/**
	 * The copyright year of the publication.
	 */
	private int copyright;
	private String loanedTo;
	private LocalDate dueDate;


	public Publication(String title, String author, int copyright) {

	if (copyright < 1900 || copyright > LocalDate.now().getYear()) {
		
		throw new IllegalArgumentException("Invalid copyright year.");
	}

	this.title = title;
	this.author = author;
	this.copyright = copyright;
	this.loanedTo = null;
	this.dueDate = null;

	}

	public void checkOut(String patron) {
	
		this.loanedTo = patron;
		this.dueDate = LocalDate.now().plusDays(14);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: ").append(title).append("\n");
		sb.append("Author: ").append(author).append("\n");
		sb.append("Copyright Year: ").append(copyright).append("\n");

		if(loanedTo != null) {
			sb.append("Loaned To: ").append(loanedTo).append("\n");
			sb.append("Due Date: ").append(dueDate).append("\n");
		}

		return sb.toString();
	}
}



