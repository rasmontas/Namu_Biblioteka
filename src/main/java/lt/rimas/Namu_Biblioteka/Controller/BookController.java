package lt.rimas.Namu_Biblioteka.Controller;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
import lt.rimas.Namu_Biblioteka.Service.AuthorService;
import lt.rimas.Namu_Biblioteka.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/books")
//http://localhost:8080/books
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


    //http://localhost:8080/books/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Book> getBooks() {
        return bookService.getAll();
    }

    //http://localhost:8080/books/search
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("key_book", new Book());
        model.addAttribute("key_book_list", bookService.getAll());
        return "books_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getBooksName(Model model, @ModelAttribute(value = "key_book") Book book) {
        model.addAttribute("key_book", book);
        model.addAttribute(
                "key_book_list",
                bookService.getBookByName(book.getName()));
        return "books_list";
    }

    //http://localhost:8080/books/save
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveBook(Model model) {
        model.addAttribute("key_book", new Book());
        model.addAttribute("key_author", new Author());
        model.addAttribute("key_author_list", authorService.getAll());

        return "note_menu_pvz";
    }


    @RequestMapping(value = "/author/provide", method = RequestMethod.POST)
    public String provideAuthorDetails(
            Model model,
            @ModelAttribute(value = "key_book") Book book,
            @ModelAttribute(value = "key_author") Author author
            ) {
        model.addAttribute("key_book", book);
        model.addAttribute("key_author", authorService.getById(author.getId()));
        return "note_menu_pvz";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(
            Model model,
            @ModelAttribute(value = "key_book") Book book,
            @ModelAttribute(value = "key_author") Author author
    ) {
        book.setAuthor(author);
        bookService.save(book);
        model.addAttribute("key_book", book);
        model.addAttribute("key_author", author);
        return "note_menu_pvz";
    }

    //http://localhost:8080/books/delete
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteBook(Book book) {
        bookService.delete(book);
        return "books_list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBooks(Model model, @ModelAttribute(value = "key_book") Book book) {
        bookService.delete(book);
        model.addAttribute("key_book", book);
        return "books_list";
    }

}
