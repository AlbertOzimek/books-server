package ch.leansoft.books;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/books")
    @CrossOrigin
	public List<Book> getAllBooks() {
		if(this.bookService.getAllBooks().isEmpty()) {
			this.bookService.createMockData(); // TODO: remove this
		}
		return this.bookService.getAllBooks();
	
	}
	
	@RequestMapping("/books/{id}")
    @CrossOrigin
	public void getBook(@PathVariable String id) {
		this.bookService.getBook(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
    @CrossOrigin
	public void addBook(@RequestBody Book book) {
       this.bookService.addBook(book);
    }

	@RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
	@CrossOrigin
	public void updateBook(@RequestBody Book book, @PathVariable String id) {
		this.bookService.updateBook(book, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
	@CrossOrigin
	public void deleteBook(@PathVariable String id) {
		this.bookService.deleteBook(id);
	}
}
