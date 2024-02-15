package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {
    @Id
    private String id;
    private String tittle;
    private  int publishYear;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
