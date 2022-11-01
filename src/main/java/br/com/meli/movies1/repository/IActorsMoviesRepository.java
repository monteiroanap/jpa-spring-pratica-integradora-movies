package br.com.meli.movies1.repository;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.model.ActorsMovies;
import br.com.meli.movies1.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IActorsMoviesRepository extends JpaRepository<ActorsMovies, Long> {

    Optional<ActorsMovies> findByActorsAndMovies(Actors actors, Movies movies);
}
