package br.com.meli.movies1.response_dto;

import br.com.meli.movies1.model.Actors;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
public class ActorsResponseDto {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String firstName;

    private String lastName;
    private Double rating;

    private MoviesResponseDto favoriteMovies;

    public ActorsResponseDto(Actors actors) {
        this.id = actors.getId();
        this.createdAt = actors.getCreatedAt();
        this.firstName = actors.getFirstName();
        this.lastName = actors.getLastName();
        this.rating = actors.getRating();
        if(actors.getMovies() != null){
            this.favoriteMovies = new MoviesResponseDto(actors.getMovies());
        }
    }
}
