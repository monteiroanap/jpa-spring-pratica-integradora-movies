package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.request_dto.ActorsRequestDto;
import br.com.meli.movies1.request_dto.GenresRequestDto;
import br.com.meli.movies1.response_dto.ActorsResponseDto;
import br.com.meli.movies1.response_dto.GenresResponseDto;
import br.com.meli.movies1.service.ActorsService;
import br.com.meli.movies1.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    @Autowired
    private ActorsService actorsService;

    @PostMapping
    public ResponseEntity<Object> createNewActors(@RequestBody ActorsRequestDto actorsRequestDto) {
        Actors actors = actorsService.createNewActors(actorsRequestDto);
        ActorsResponseDto actorsResponseDto = new ActorsResponseDto(actors);
        return new ResponseEntity<>(actorsResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllActors(){
        return new ResponseEntity<>(actorsService.getAllActors(),HttpStatus.OK);
    }

}
