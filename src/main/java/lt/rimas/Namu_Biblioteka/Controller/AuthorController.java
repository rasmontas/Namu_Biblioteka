package lt.rimas.Namu_Biblioteka.Controller;

import lombok.AllArgsConstructor;
import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/author")
//http://localhost:8080/author
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //http://localhost:8080/author/all
    @GetMapping(path = "/all")
    public @ResponseBody List<Author> getAuthors(){
        return authorService.getAll();
    }
    //http://localhost:8080/author/search
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getAuthors(Model model) {
        model.addAttribute("key_author", new Author());
        model.addAttribute("key_author_list", authorService.getAll());
        return "authors_list";
    }

}
