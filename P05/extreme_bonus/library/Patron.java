// Copyright 2023 Raisa Tasnim <https://github.com/gitraisa/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>
package library;

/**
 * A person authorized to check out a library resource.
 *
 * @author             Professor George F. Rice
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
    private String name;
    private String email;
}