package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.request_dto.GenresRequestDto;
import br.com.meli.movies1.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenresController {

    @Autowired
    private GenresService genresService;

    @PostMapping("/genres")
    public ResponseEntity<Genres> createNewMovie(@RequestBody GenresRequestDto genresRequestDto) {
        return new ResponseEntity<>(genresService.createNewGenres(genresRequestDto),HttpStatus.CREATED);
    }
}
