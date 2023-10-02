package library;

import java.util.ArrayList;

/**
 * Models a library containing various publications.
 *
 * @author             Raisa Tasnim
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
 public class Library {
    /**
     * Creates a Library instance.
     *
     * @param name         the name of the library
     * @since              1.0
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }
    /**
     * Adds a publication to this library instance.
     *
     * @param publication  the publication to add to the library
     * @since              1.0
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    /**
     * Checks out a publication from this library instance.
     *
     * The due date will be set to 2 weeks from the current date.
     *
     * @param publicationIndex  the index as shown by toString()
     * @param patron            identification of the borrower
     * @since                   1.0
     */
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }
    /**
     * Checks in a publication or video by setting its loanedTo and dueDate to null.
     * 
     * @param publicationIndex the index as shown by toString()
     * @since 1.0
     */
    public void checkIn(int publicationIndex) {
        try {
            Publication publication = publications.get(publicationIndex);
            if (publication.isLoaned()) {
                publication.checkIn();
                System.out.println("Publication #" + publicationIndex + " has been checked in.");
            } else {
                System.out.println("Publication #" + publicationIndex + " is not checked out.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid publication index: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nUnable to check in publication #" + publicationIndex + ": " + e.getMessage() + "\n");
        }
    }
    
    /**
     * Lists all publications in this library instance.
     *
     * The index shown in the resulting String may be used 
     * to check out a publication using the checkOut() method.
     *
     * @returns     the string representation of all library publications
     * @since       1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============= \n");
        sb.append(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications;
}