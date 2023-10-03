// Copyright 2023 Raisa Tasnim <https://github.com/gitraisa/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>

package mdi;

import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class LibraryManager {
    public static void main(String[] args) {
        Library library = null;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("========");
            System.out.println("Main Menu");
            System.out.println("========");

            System.out.println("UTA Library\n");
            System.out.println("Publications");
            System.out.println("1) List");
            System.out.println("2) Add");
            System.out.println("3) Check out");
            System.out.println("4) Check in");
            System.out.println("Patrons");
            System.out.println("5) List");
            System.out.println("6) Add");

            System.out.println("Files");
            System.out.println("7) Load File");
            System.out.println("0) Exit");

            System.out.print("Selection: ");
            int selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 0:
                    System.out.println("Exiting Library Manager. Goodbye!");
                    System.exit(0);
                    break;
                case 1:
                    if (library != null) {
                        System.out.println("\n============= Library Catalogue =============\n");
                        System.out.println(library);
                    } else {
                        System.out.println("Please load a file first (Option 7).");
                    }
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
                    System.out.println("Publications");

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
                    System.out.println("Publications");
                
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
                    try (BufferedReader br = new BufferedReader(new FileReader("library.txt"))) {
                        String name;
                        library = new Library(br.readLine());
                        while ((name = br.readLine()) != null) {
                            if (name.isEmpty()) break;
                            if (name.equals("Publication")) {
                                library.addPublication(new Publication(br.readLine(), br.readLine(),
                                        Integer.parseInt(br.readLine())));
                            } else if (name.equals("Video")) {
                                library.addPublication(new Video(br.readLine(), br.readLine(),
                                        Integer.parseInt(br.readLine()),
                                        Integer.parseInt(br.readLine())));
                            } else {
                                throw new IOException("Unable to load library.txt");
                            }
                        }
                        while ((name = br.readLine()) != null) {
                            if (name.isEmpty()) break;
                            library.addPatron(new Patron(name, br.readLine()));
                        }
                        System.out.println("\nFile loaded successfully.");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Invalid copyright year - " + e);
                    } catch (IOException e) {
                        System.err.println("Error reading file library.txt - " + e);
                    } catch (Exception e) {
                        System.err.println("Unexpected exception - " + e);
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}