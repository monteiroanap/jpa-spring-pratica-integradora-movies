package br.com.meli.movies1.repository;


import br.com.meli.movies1.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movies, Long> {
}
