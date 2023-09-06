package lt.rimas.Namu_Biblioteka.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // http://localhost:8080
    @GetMapping(path = "/")
    public String displayHomePage(){
        return "home";
    }
}
