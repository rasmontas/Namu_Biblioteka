package lt.rimas.Namu_Biblioteka.Service;

import lt.rimas.Namu_Biblioteka.Repository.BookRepository;
import lt.rimas.Namu_Biblioteka.Repository.Model.Author;
import lt.rimas.Namu_Biblioteka.Repository.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> getBookByName(String name){
        return bookRepository.getBookByName("%" + name + "%");
    }

    public void delete(Book book){
        bookRepository.delete(book);

    }



}
