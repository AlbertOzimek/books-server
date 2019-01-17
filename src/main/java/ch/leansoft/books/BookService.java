package ch.leansoft.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private List<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("111", "Eine kurze Geschichte der Menscheit", "Yuval Noah Harari", "2016", "DVA", 36),
            new Book("222", "Homo Deus", "Yuval Noah Harari", "2017", "CHBECK", 37),
            new Book("333", "21 Lektionen", "Yuval Noah Harari", "2017", "CHBECK", 37)));

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book getBook(String id) {
        return this.books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> updateBook(Book book, String id) {
        for (int i = 0; i < this.books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
              books.set(i, book);
            }
        }
        return this.books;
    }

    public void deleteBook(String id) {
        this.books.removeIf(b -> b.getId().equals(id));
    }
}
