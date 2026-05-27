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
