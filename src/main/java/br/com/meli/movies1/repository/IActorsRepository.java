package br.com.meli.movies1.repository;

import br.com.meli.movies1.model.Actors;
import br.com.meli.movies1.request_dto.ActorsRequestDto;
import br.com.meli.movies1.response_dto.ActorsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorsRepository extends JpaRepository<Actors, Integer> {
}
