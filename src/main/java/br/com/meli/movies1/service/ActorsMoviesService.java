package br.com.meli.movies1.service;

import br.com.meli.movies1.model.ActorsMovies;
import br.com.meli.movies1.repository.IActorsMoviesRepository;
import br.com.meli.movies1.repository.IActorsRepository;
import br.com.meli.movies1.response_dto.ActorsMoviesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsMoviesService {

    @Autowired
    private IActorsMoviesRepository repo;
    public List<ActorsMovies> getAllActorsMovies() {
       return repo.findAll();
    }

    //consultar se existe o ator e filme pelo id, ai pego esses objetos que esta no banco
    //e setar no objeto novo ACTORMOVIE

}
