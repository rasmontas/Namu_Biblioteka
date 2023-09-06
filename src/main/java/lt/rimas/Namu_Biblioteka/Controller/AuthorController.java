package lt.rimas.Namu_Biblioteka.Controller;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
