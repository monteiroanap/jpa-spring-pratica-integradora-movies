package br.com.meli.movies1.response_dto;

import br.com.meli.movies1.model.Movies;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class MoviesResponseDto implements Serializable {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer lenght;
    private GenresResponseDto genres;


    public MoviesResponseDto(Movies movies) {
        this.id = movies.getId();
        this.createdAt = movies.getCreatedAt();
        this.updatedAt = movies.getUpdatedAt();
        this.title = movies.getTitle();
        this.rating = movies.getRating();
        this.awards = movies.getAwards();
        this.releaseDate = movies.getReleaseDate();
        this.lenght = movies.getLenght();
        this.genres = new GenresResponseDto(movies.getGenres());
    }
}
