package br.com.meli.movies1.request_dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Getter
public class ActorsRequestDto implements Serializable {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Double rating;

    private Integer favoriteMovies; // id de um filme

}
