package lt.rimas.Namu_Biblioteka.Controller;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
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

    //http://localhost:8080/books/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Book> getBooks(){
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


}
