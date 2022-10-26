package br.com.meli.movies1.repository;


import br.com.meli.movies1.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenresRepository extends JpaRepository<Genres, Integer> {
}
