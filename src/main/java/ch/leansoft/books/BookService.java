package ch.leansoft.books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createMockData() {
        // TODO: remove hardcoded code
        List<Book> books = new ArrayList<Book>(Arrays.asList(
                new Book("111", "Eine kurze Geschichte der Menscheit", "Yuval Noah Harari", "2016", "DVA", 36),
                new Book("222", "Homo Deus", "Yuval Noah Harari", "2017", "CHBECK", 37),
                new Book("333", "21 Lektionen", "Yuval Noah Harari", "2017", "CHBECK", 37)));
        this.bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        this.bookRepository.findAll().forEach(books::add);
        return books;
    }

    public Optional<Book> getBook(String id) {
        return this.bookRepository.findById(id);
    }

    public void addBook(Book book) {
        this.bookRepository.save(book);
    }

    public void updateBook(Book book, String id) {
      this.bookRepository.save(book);
    }

    public void deleteBook(String id) {
        this.bookRepository.deleteById(id);
    }
}
