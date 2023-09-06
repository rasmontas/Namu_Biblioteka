package lt.rimas.Namu_Biblioteka.Repository;

import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
