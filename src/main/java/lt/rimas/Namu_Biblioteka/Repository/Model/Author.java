package lt.rimas.Namu_Biblioteka.Repository.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@ToString
public class Author {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Integer dateOfBirth;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Book> books = new ArrayList<>();



    public Author() {

    }

    public Author(
            Integer id,
            String firstName,
            String lastName,
            Integer dateOfBirth,
            String country,
            String description
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }
}
