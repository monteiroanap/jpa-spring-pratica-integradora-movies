package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.repository.IGenresRepository;
import br.com.meli.movies1.request_dto.GenresRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
