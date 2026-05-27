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

public void searchBook(String title) {

    boolean found = false;

    for (Book book : books) {

        if (book.getTitle().equalsIgnoreCase(title)) {
            System.out.println(book);
            found = true;
        }
    }

    if (!found) {
        System.out.println("Libro non trovato.");
    }
}

public void borrowBook(String title) {

    for (Book book : books) {

        if (book.getTitle().equalsIgnoreCase(title)) {

            if (book.isAvailable()) {
                book.borrowBook();
                System.out.println("Libro prestato con successo.");
            } else {
                System.out.println("Libro già prestato.");
            }

            return;
        }
    }

    System.out.println("Libro non trovato.");
}

public void returnBook(String title) {

    for (Book book : books) {

        if (book.getTitle().equalsIgnoreCase(title)) {

            if (!book.isAvailable()) {
                book.returnBook();
                System.out.println("Libro restituito.");
            } else {
                System.out.println("Il libro era già disponibile.");
            }

            return;
        }
    }

    System.out.println("Libro non trovato.");
}
