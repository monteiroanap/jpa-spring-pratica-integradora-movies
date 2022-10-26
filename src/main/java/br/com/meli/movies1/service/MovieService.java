package br.com.meli.movies1.service;

import br.com.meli.movies1.model.Genres;
import br.com.meli.movies1.model.Movies;
import br.com.meli.movies1.repository.IGenresRepository;
import br.com.meli.movies1.repository.IMovieRepository;
import br.com.meli.movies1.request_dto.MoviesRequestDto;
import br.com.meli.movies1.response_dto.MoviesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IGenresRepository genresRepository;

    public Movies createNewMovies(MoviesRequestDto moviesRequestDto) throws Exception {
        Optional<Genres> optionalGenres = genresRepository.findById(moviesRequestDto.getGenre());
        if(optionalGenres.isPresent()){
            Movies movies = new Movies();
            movies.setRating(moviesRequestDto.getRating());
            movies.setTitle(moviesRequestDto.getTitle());
            movies.setAwards(moviesRequestDto.getAwards());
            movies.setLenght(moviesRequestDto.getLenght());
            movies.setGenres(optionalGenres.get());
            movies.setReleaseDate(moviesRequestDto.getReleaseDate());
            return  movieRepository.save(movies);
        }
        throw new Exception("genero não encontrado");
    }

    public List<MoviesResponseDto> getAllMovies() {
        List<Movies> movies = movieRepository.findAll();
        return movies.stream().map(MoviesResponseDto::new).collect(Collectors.toList());
    }
}
