package lt.rimas.Namu_Biblioteka.Repository.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Book {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date_of_publish")
    private Integer dateOfPublish;

    @Column(name = "availability")
    private String availability;

    @Column(name = "rating")
    private String rating;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @PrimaryKeyJoinColumn
    @JsonBackReference
    private Author author;

    public Book(
            Author author,
            String name,
            String genre,
            Integer dateOfPublish,
            String availability,
            String rating
    ) {
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.dateOfPublish = dateOfPublish;
        this.availability = availability;
        this.rating = rating;
    }
}
