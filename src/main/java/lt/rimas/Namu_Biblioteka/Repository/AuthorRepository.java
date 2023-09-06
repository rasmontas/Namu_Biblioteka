package lt.rimas.Namu_Biblioteka.Repository;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
