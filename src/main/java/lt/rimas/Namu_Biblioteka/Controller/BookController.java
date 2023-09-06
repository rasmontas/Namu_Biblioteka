package lt.rimas.Namu_Biblioteka.Controller;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
import lt.rimas.Namu_Biblioteka.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
