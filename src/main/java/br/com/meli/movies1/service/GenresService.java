package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.repository.IGenresRepository;
import br.com.meli.movies1.request_dto.GenresRequestDto;
import br.com.meli.movies1.response_dto.GenresResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenresService {

    @Autowired
    private IGenresRepository genresRepository;

    public Genres createNewGenres(GenresRequestDto genresRequestDto) {
        Genres genres = new Genres();
        genres.setName(genresRequestDto.getName());
        genres.setRanking(genresRequestDto.getRanking());
        genres.setActive(genresRequestDto.isActive());
        return genresRepository.save(genres);
    }

    public List<GenresResponseDto> getAllGenres() {
        List<Genres> genres = genresRepository.findAll();
        return genres.stream().map(GenresResponseDto::new).collect(Collectors.toList()); // metodo por referencia
       //return genres.stream().map(g -> new GenresResponseDto(g)).collect(Collectors.toList()); - lambda
    }
}
