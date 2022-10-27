package br.com.meli.movies1.model;

import br.com.meli.movies1.request_dto.ActorsRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@NoArgsConstructor
@Entity
@Table(name = "actors")
@Data

public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(columnDefinition = "Decimal(3,1)")
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_favorite_movie")
    private Movies movies;

    // ManyToOne: Um filme pode ser de muitos atores - perpectiva do filme
                 // um ator so tem um filme - perpectiva do ator


    public Actors(ActorsRequestDto actorsRequestDto) {
        this.id = actorsRequestDto.getId();
        this.updatedAt = LocalDateTime.now();
        this.firstName = actorsRequestDto.getFirstName();
        this.lastName = actorsRequestDto.getLastName();
        this.rating = actorsRequestDto.getRating();
        if(actorsRequestDto.getFavoriteMovies() != null){
            this.movies = new Movies(actorsRequestDto.getFavoriteMovies());
        }
    }

    public Actors(Integer id) {
        this.id = id;
    }
}
