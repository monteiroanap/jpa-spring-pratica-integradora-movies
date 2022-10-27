package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.request_dto.GenresRequestDto;
import br.com.meli.movies1.response_dto.GenresResponseDto;
import br.com.meli.movies1.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;


@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresService genresService;

    @PostMapping
    public ResponseEntity<Object> createNewGenre(@RequestBody GenresRequestDto genresRequestDto) {
        Genres genres = genresService.createNewGenres(genresRequestDto);
        GenresResponseDto genresResponseDto = new GenresResponseDto(genres);
        return new ResponseEntity<>(genresResponseDto,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAllGenres() {
        return new ResponseEntity<>(genresService.getAllGenres(),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Object> updateGenres(@RequestBody GenresRequestDto genresRequestDto) throws Exception {
        GenresResponseDto genresUpdated = genresService.update(genresRequestDto);
        return new ResponseEntity<>(genresUpdated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGenres(@PathVariable Integer id) {
        try {
            genresService.delete(id);
        } catch (SQLIntegrityConstraintViolationException e) {
            return new ResponseEntity<>("erro ao deletar o genero",HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("genero deletado com sucesso",HttpStatus.OK);
    }
}
