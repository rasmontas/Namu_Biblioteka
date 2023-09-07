package lt.rimas.Namu_Biblioteka.Repository;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


    @Query(
            value = "SELECT * FROM authors WHERE name LIKE :firstName",
            nativeQuery = true
    )
    List<Author> getAuthorByNameLike(String firstName);

    @Query(
            value = "SELECT * FROM authors WHERE last_name LIKE :lastName",
            nativeQuery = true
    )
    List<Author> getAuthorByLastNameLike(String lastName);


}
