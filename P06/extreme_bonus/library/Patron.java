package library;

import java.io.*;

/**
 * A person authorized to check out a library resource.
 *
 * @author             Raisa Tasnim
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Patron {
    /**
     * Creates a Patron instance.
     *
     * @param name     the name on the patron's ID card
     * @param email    the email address reported by the patron and verified by the library staff
     * @since              1.0
     */
    public Patron(String name, String email) {
        this.name = name;
        this.email = email;
    }
    /**
     * Formats the fields of the patron in human-readable form.
     *
     * @returns     the string representation of the patron
     * @since       1.0
     */

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }

    /**
     * Writes the patron's data to a BufferedWriter stream.
     * 
     * @param bw the BufferedWriter to write to
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name);
        bw.newLine();
        bw.write(email);
        bw.newLine();
    }
    /**
     * Reads patron's data from a BufferedReader stream and creates a Patron instance.
     * 
     * @param br the BufferedWriter to read from
     * @return a new Patron instance with data read from the stream
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */

    public static Patron load(BufferedReader br) throws IOException {
        String name = br.readLine();
        String email = br.readLine();
        return new Patron(name, email);
    }

    private String name;
    private String email;
}