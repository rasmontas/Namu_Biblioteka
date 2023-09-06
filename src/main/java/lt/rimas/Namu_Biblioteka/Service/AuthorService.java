package lt.rimas.Namu_Biblioteka.Service;

import lt.rimas.Namu_Biblioteka.Repository.AuthorRepository;
import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public List<Author> getAll() {
        return (List<Author>) authorRepository.findAll();
    }

}

