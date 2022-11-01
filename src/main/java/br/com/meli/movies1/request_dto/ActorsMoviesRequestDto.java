package br.com.meli.movies1.request_dto;


import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.Movies;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ActorsMoviesRequestDto {

    @NotNull
    private Actors idActors;

    @NotNull
    private Movies idMovies;

}
