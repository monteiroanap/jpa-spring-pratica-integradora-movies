package br.com.meli.movies1.controller;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.request_dto.ActorsRequestDto;
import br.com.meli.movies1.response_dto.ActorsResponseDto;
import br.com.meli.movies1.service.ActorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Validated
@RestController
@RequestMapping("/actors")
public class ActorsController {
    @Autowired
    private ActorsService actorsService;


    @PostMapping
    public ResponseEntity<Object> createNewActors(@RequestBody @Valid ActorsRequestDto actorsRequestDto) {
        Actors actors = actorsService.createNewActors(actorsRequestDto);
        ActorsResponseDto actorsResponseDto = new ActorsResponseDto(actors);
        return new ResponseEntity<>(actorsResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllActors(){
        return new ResponseEntity<>(actorsService.getAllActors(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateActors(@RequestBody @Valid ActorsRequestDto actorsRequestDto) throws Exception {
        ActorsResponseDto actorUpdate = actorsService.updateActors(actorsRequestDto);
        return new ResponseEntity<>(actorUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteActors(@PathVariable @Valid Integer id)  {
        try {
            actorsService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ator deletado com sucesso", HttpStatus.OK);
    }
}
