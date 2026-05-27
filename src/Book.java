public class Book {

    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    @Override
    public String toString() {
        return title + " - " + author +
                (available ? " [Disponibile]" : " [Prestato]");
    }
}

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Nessun libro presente.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {
            System.out.println("\n=== LIBRARY MENU ===");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Mostra libri");
            System.out.println("3. Esci");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Titolo: ");
                    String title = scanner.nextLine();

                    System.out.print("Autore: ");
                    String author = scanner.nextLine();

                    library.addBook(new Book(title, author));

                    System.out.println("Libro aggiunto!");
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
