package lt.rimas.Namu_Biblioteka.Repository.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")



@ToString

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getDateOfPublish() {
        return dateOfPublish;
    }

    public String getAvailability() {
        return availability;
    }

    public String getRating() {
        return rating;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateOfPublish(Integer dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
