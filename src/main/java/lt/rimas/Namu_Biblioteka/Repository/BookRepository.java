package lt.rimas.Namu_Biblioteka.Repository;

import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Query(
            value = "SELECT * FROM books WHERE name",
            nativeQuery = true
    )
    List<Book> getBookByName(String name);
}
