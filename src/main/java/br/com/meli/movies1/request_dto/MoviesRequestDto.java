package br.com.meli.movies1.request_dto;

import javax.validation.constraints.NotNull;


import br.com.meli.movies1.model.Movies;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MoviesRequestDto {

    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private Double rating;

    @NotNull
    private Integer awards;

    @NotNull
    private Integer lenght;

    @NotNull
    private Integer genre;

    private LocalDate releaseDate;

}
