package mdi;

import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.util.Scanner;
import java.io.*;

public class LibraryManager {
    private static Library library = new Library("UTA Library");

    public static void main(String[] args) {
        library.addPublication(new Publication("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997));
        library.addPublication(new Publication("Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998));
        library.addPublication(new Publication("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999));
        library.addPublication(new Video("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000, 157));
        library.addPublication(new Video("Harry Potter and the Order of the Phoenix", "J.K. Rowling", 2003, 138));
        library.addPublication(new Video("Harry Potter and the Half-Blood Prince", "J.K. Rowling", 2005, 153));
        
        library.addPatron(new Patron("Raisa Tasnim", "rxt@mavs.uta.edu"));
        library.addPatron(new Patron("Isaac Ramirez", "isaac.ramirez@peace.org"));
        library.addPatron(new Patron("Sufia Afrin", "afrinsufia00@stand.we"));
        library.addPatron(new Patron("Rejmin Tasnim", "rxt@college.edu"));
        library.addPatron(new Patron("William Shakespreare", "william@english.lit"));
        library.addPatron(new Patron("Barack Obama", "obamacare@america.gov"));

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

            System.out.println("Patrons");
            System.out.println("5) List");
            System.out.println("6) Add");

            System.out.println("Files");
            System.out.println("7) Open library");
            System.out.println("8) Save library");


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
            case 5:
                if (library != null) {
                    System.out.println("\nList of Patrons");
                    System.out.println("=============\n");
                    System.out.println(library.listPatrons());
                }
                break;
            case 6:
                System.out.println("\nAdd a new patron:");
                System.out.print("Enter patron name: ");
                String patronNameToAdd = scanner.nextLine();
                System.out.print("Enter patron email: ");
                String patronEmailToAdd = scanner.nextLine();
                library.addPatron(new Patron(patronNameToAdd, patronEmailToAdd));
                System.out.println("Patron added successfully.");
                break;
            case 7:
                openLibrary();
                break;
            case 8:
                saveLibrary();
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void saveLibrary() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the filename to save the library: ");
            String filename = scanner.nextLine();

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                library.save(bw);
                System.out.println("Library saved to " + filename);
            } catch (IOException e) {
                System.err.println("Error saving the library to " + filename + ": " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void openLibrary() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the filename to open the library: ");
            String filename = scanner.nextLine();

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                library = new Library(br);
                System.out.println("Library loaded from " + filename);
            } catch (IOException e) {
                System.err.println("Error opening the library from " + filename + ": " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}