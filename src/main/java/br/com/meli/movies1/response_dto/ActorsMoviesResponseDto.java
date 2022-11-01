package br.com.meli.movies1.response_dto;

import br.com.meli.movies1.model.ActorsMovies;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@NoArgsConstructor
@Data
public class ActorsMoviesResponseDto implements Serializable {
    private Long id;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt;
    private ActorsResponseDto actorsResponseDto;
    private MoviesResponseDto moviesResponseDto;

    public ActorsMoviesResponseDto(ActorsMovies actorsMovies) {
        this.id = actorsMovies.getId();
        this.createdAt = actorsMovies.getCreatedAt();
        this.updatedAt = actorsMovies.getUpdatedAt();
        this.actorsResponseDto = new ActorsResponseDto(actorsMovies.getActors());
        this.moviesResponseDto = new MoviesResponseDto(actorsMovies.getMovies());

    }
}

