package br.com.meli.movies1.repository;

import br.com.meli.movies1.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorsRepository extends JpaRepository<Actors, Integer> {
}
