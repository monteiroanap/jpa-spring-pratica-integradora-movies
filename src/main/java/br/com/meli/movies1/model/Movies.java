package br.com.meli.movies1.model;

import br.com.meli.movies1.request_dto.MoviesRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Decimal(3,1)")
    private Double rating;

    @Column
    private Integer awards;

    @Column(name = "release_date")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate releaseDate;

    @Column
    private Integer lenght;

    @ManyToOne(fetch = FetchType.LAZY)
    // muitos filmes tem apenas UM genero
    @JoinColumn(name = "fk_genres", nullable = false)
    private Genres genres;

    @OneToMany(mappedBy = "movies", cascade ={CascadeType.MERGE, CascadeType.PERSIST})
    private Set<ActorsMovies> actorMovies;


    public Movies(MoviesRequestDto moviesRequestDto) {
        this.id = moviesRequestDto.getId();
        this.title = moviesRequestDto.getTitle();
        this.rating = moviesRequestDto.getRating();
        this.awards = moviesRequestDto.getAwards();
        this.lenght = moviesRequestDto.getLenght();
        this.genres = new Genres(moviesRequestDto.getGenre());
        this.releaseDate = moviesRequestDto.getReleaseDate();
        this.updatedAt = LocalDateTime.now();
    }

    public Movies(Integer id) {
        this.id = id;
    }

    @PrePersist
    public void setup(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
