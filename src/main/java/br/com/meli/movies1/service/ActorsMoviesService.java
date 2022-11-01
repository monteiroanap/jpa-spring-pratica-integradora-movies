package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.ActorsMovies;
import br.com.meli.movies1.model.Movies;
import br.com.meli.movies1.repository.IActorsMoviesRepository;
import br.com.meli.movies1.request_dto.ActorsMoviesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsMoviesService {

    @Autowired
    private IActorsMoviesRepository repo;

    @Autowired
    private ActorsService actorsService;

    @Autowired
    private MovieService movieService;

    public List<ActorsMovies> getAllActorsMovies() {
       return repo.findAll();
    }

    public ActorsMovies createActorMovies(ActorsMoviesRequestDto actorsMoviesRequestDto) throws Exception{
        ActorsMovies actorsMovies = new ActorsMovies();
        Optional<Actors> actors = actorsService.getById(actorsMoviesRequestDto.getIdActors());
        Optional<Movies> movies = movieService.getById(actorsMoviesRequestDto.getIdMovies());
        if(actors.isPresent() && movies.isPresent()){
            Optional<ActorsMovies> actorsMoviesOptional = repo.findByActorsAndMovies(actors.get(),movies.get());
            if(!actorsMoviesOptional.isPresent()){
                actorsMovies.setActors(actors.get());
                actorsMovies.setMovies(movies.get());
                return repo.save(actorsMovies);
            }
        }
        throw new Exception("ator ou filme nao encontrado");
    }

    public void deleteActorsMovies(Integer idActor, Integer idMovie) throws Exception{
        Optional<Actors> actors = actorsService.getById(idActor);
        Optional<Movies> movies = movieService.getById(idMovie);
        if(actors.isPresent() && movies.isPresent()){
            Optional<ActorsMovies> actorsMoviesOptional = repo.findByActorsAndMovies(actors.get(),movies.get());
            if(actorsMoviesOptional.isPresent()){
                repo.delete(actorsMoviesOptional.get());
            }
        }else{
            throw new Exception("ator ou filme nao encontrado");
        }
    }




}
