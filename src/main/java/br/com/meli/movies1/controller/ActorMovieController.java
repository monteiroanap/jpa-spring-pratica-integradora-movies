package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.ActorsMovies;
import br.com.meli.movies1.request_dto.ActorsMoviesRequestDto;
import br.com.meli.movies1.response_dto.ActorsMoviesResponseDto;
import br.com.meli.movies1.service.ActorsMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actorsMovies")
public class ActorMovieController {

    @Autowired
    private ActorsMoviesService actorsMoviesService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<ActorsMoviesResponseDto> actorsMoviesResponseDto = new ArrayList<>();
        List<ActorsMovies> actorsMovies = actorsMoviesService.getAllActorsMovies();
        actorsMoviesResponseDto = actorsMovies.stream().map(ActorsMoviesResponseDto::new).collect(Collectors.toList());
//        actorsMoviesResponseDto = actorsMovies.stream().map(a -> {
//            ActorsMoviesResponseDto actorsMoviesResponseDto1 = new ActorsMoviesResponseDto();
//            actorsMoviesResponseDto1.setId(a.getId());
//            return actorsMoviesResponseDto1;
//        } ).collect(Collectors.toList());
        return new ResponseEntity<>(actorsMoviesResponseDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> createActorsMovies(@RequestBody ActorsMoviesRequestDto actorsMoviesRequestDto) {


    }
    //receber no json o id do ator e filme qu eu quero vincular
}
