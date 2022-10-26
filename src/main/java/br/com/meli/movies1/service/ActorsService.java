package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.Movies;
import br.com.meli.movies1.repository.IActorsRepository;
import br.com.meli.movies1.repository.IMovieRepository;
import br.com.meli.movies1.request_dto.ActorsRequestDto;
import br.com.meli.movies1.response_dto.ActorsResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorsService {

    @Autowired
    private IActorsRepository actorsRepository;

    @Autowired
    private IMovieRepository movieRepository;

    public Actors createNewActors (ActorsRequestDto actorsRequestDto) {
        Actors actors = new Actors();
        Optional<Movies> favoriteMovies = null;
        if(actorsRequestDto.getFavoriteMovies() != null) {
            favoriteMovies = movieRepository.findById(actorsRequestDto.getFavoriteMovies());
            actors.setMovies(favoriteMovies.isPresent() ? favoriteMovies.get() : null);
        }
        actors.setFirstName(actorsRequestDto.getFirstName());
        actors.setLastName(actorsRequestDto.getLastName());
        actors.setRating(actorsRequestDto.getRating());
        return actorsRepository.save(actors);
    }

    public List<ActorsResponseDto> getAllActors(){
        List<Actors> actors = actorsRepository.findAll();
        return actors.stream().map(ActorsResponseDto::new).collect(Collectors.toList());
    }
}
