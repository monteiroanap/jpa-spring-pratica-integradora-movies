package br.com.meli.movies1.repository;

import br.com.meli.movies1.model.ActorsMovies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorsMoviesRepository extends JpaRepository<ActorsMovies, Long> {
}
