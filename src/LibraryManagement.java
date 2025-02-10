import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

public class LibraryManagement {
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. List All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch(choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    searchBook(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        books.add(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private static void listBooks() {
        System.out.println("\nBooks in Library:");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter title to search: ");
        String query = scanner.nextLine().toLowerCase();
        System.out.println("Search Results:");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the given title.");
        }
    }
}
