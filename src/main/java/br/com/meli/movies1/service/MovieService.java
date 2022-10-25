package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Movies;
import br.com.meli.movies1.repository.IMovieRepository;
import br.com.meli.movies1.request_dto.MoviesRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    public Movies createNewMovies(MoviesRequestDto moviesRequestDto) {
        Movies movies = new Movies();
        movies.setRating(moviesRequestDto.getRating());
        movies.setTitle(moviesRequestDto.getTitle());
        movies.setAwards(moviesRequestDto.getAwards());
        movies.setLenght(moviesRequestDto.getLenght());
        return  movieRepository.save(movies);
    }

}
