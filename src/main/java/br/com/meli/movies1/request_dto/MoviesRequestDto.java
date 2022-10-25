package br.com.meli.movies1.request_dto;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class MoviesRequestDto {

    @NotNull
    private String title;

    @NotNull
    private Double rating;

    @NotNull
    private Integer awards;

    @NotNull
    private Integer lenght;
}
