package br.com.meli.movies1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actor_movie")
@Data
@NoArgsConstructor
public class ActorsMovies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "actor_id")
    private Actors actors;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "movies_id")
    private Movies movies;

    public ActorsMovies(Actors actors, Movies movies) {
        this.actors = actors;
        this.movies = movies;
    }
    @PrePersist
    public void setup(){
        this.createdAt = LocalDateTime.now();
        setupUpdatedAt();
    }

    public void setupUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }
}
