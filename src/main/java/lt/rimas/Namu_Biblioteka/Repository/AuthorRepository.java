package lt.rimas.Namu_Biblioteka.Repository;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


    @Query(
            value = "SELECT * FROM authors WHERE name",
            nativeQuery = true
    )
    List<Author> getAuthorByNameLike(String name);

    @Query(
            value = "SELECT * FROM authors WHERE last_name",
            nativeQuery = true
    )
    List<Author> getAuthorByLastNameLike(String name);
}
