package br.com.meli.movies1.request_dto;


import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.Movies;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class ActorsMoviesRequestDto implements Serializable {

    @NotNull
    private Integer idActors;

    @NotNull
    private Integer idMovies;

}
