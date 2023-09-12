import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Publication {
	
	private String title;
	private String author;
	private int copyright;
	private Patron loanedTo;
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

	public void checkOut(Patron patron) {
	
		this.loanedTo = patron;
		this.dueDate = LocalDate.now().plusDays(14);
	}

	 public String getTitle() {
        return title;
    }

    public Patron getLoanedTo() {
        return loanedTo;
    }

    public LocalDate getDueDate() {
        return dueDate;
	}
}



