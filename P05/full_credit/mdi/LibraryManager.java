// Copyright 2023 Raisa Tasnim <https://github.com/gitraisa/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>

package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library("UTA Library");

        library.addPublication(new Publication("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.addPublication(new Publication("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        library.addPublication(new Publication("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999));
        library.addPublication(new Video("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 157));
        library.addPublication(new Video("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003, 138));
        library.addPublication(new Video("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005, 153));
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========");
            System.out.println("Main Menu");
            System.out.println("========\n");
            System.out.println("UTA Library");
            System.out.println("0) Exit");
            System.out.println("1) List");
            System.out.println("2) Add");
            System.out.println("3) Check Out");
            System.out.println("4) Check in");

            System.out.print("Selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
            case 0:
                System.out.println("Exiting Library Manager. Goodbye!");
                System.exit(0);
                break;
            case 1:
                System.out.println("\n=============");
                System.out.println("Library Catalogue");
                System.out.println("=============\n");
                System.out.println(library);
                break;
            case 2:
                System.out.println("\nAdd new publication or video:");
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter author/director: ");
                String authorDirector = scanner.nextLine();
                System.out.print("Enter copyright year: ");
                int copyright = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Is is a (1) Publication or (2) Video? ");
                int type = scanner.nextInt();
                scanner.nextLine();

                if( type == 1) {
                    library.addPublication(new Publication(title, authorDirector, copyright));
                } else if (type == 2) {
                    System.out.print("Enter runtime (in minutes) for the video: ");
                    int runtime = scanner.nextInt();
                    scanner.nextLine();
                    library.addPublication(new Video(title, authorDirector, copyright, runtime));
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
                break;
            case 3:
                System.out.println("\nCheck out a publication or video:");

                System.out.println("\n=============");
                System.out.println("Library Catalogue");
                System.out.println("=============\n");
                System.out.println(library);

                System.out.print("Enter the index of the item you want to check out: ");
                int checkoutIndex = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the Patron's name: ");
                String patronName = scanner.nextLine();
                library.checkOut(checkoutIndex, patronName);
                break;
            case 4:
                System.out.println("\nCheck in a publication or video");
                System.out.println("\n=============");
                System.out.println("Library Catalogue");
                System.out.println("=============\n");
                System.out.println(library);
                System.out.print("Enter the index of the item you want to check in: ");
                int checkinIndex = scanner.nextInt();
                scanner.nextLine();
                library.checkIn(checkinIndex);
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
            }
        }

    }
}