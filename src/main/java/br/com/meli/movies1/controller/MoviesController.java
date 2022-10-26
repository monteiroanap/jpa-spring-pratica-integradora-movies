package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Movies;
import br.com.meli.movies1.request_dto.MoviesRequestDto;
import br.com.meli.movies1.response_dto.MoviesResponseDto;
import br.com.meli.movies1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Object> createNewMovie(@RequestBody @Valid MoviesRequestDto moviesRequestDto) throws Exception {
        Movies movies = movieService.createNewMovies(moviesRequestDto);
        MoviesResponseDto moviesResponseDto = new MoviesResponseDto(movies);
        return new ResponseEntity<>(moviesResponseDto,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

}
