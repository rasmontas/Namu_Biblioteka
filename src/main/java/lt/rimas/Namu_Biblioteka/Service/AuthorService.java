package lt.rimas.Namu_Biblioteka.Service;

import lt.rimas.Namu_Biblioteka.Repository.AuthorRepository;
import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void delete(Author author){
        authorRepository.delete(author);

    }

    public List<Author> getAll() {
        return (List<Author>) authorRepository.findAll();
    }

    public List<Author> getAuthorByNameLike(String name){
        return authorRepository.getAuthorByNameLike("%" + name + "%");
    }

    public List<Author> getAuthorByLastNameLike(String lastName){
        return authorRepository.getAuthorByLastNameLike("%" + lastName + "%");
    }
}


