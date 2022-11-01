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

    public Optional<Movies> getById(Integer id) {
        return movieRepository.findById(id);
    }

    public MoviesResponseDto update(MoviesRequestDto moviesRequestDto) throws Exception{
        Optional<Movies> moviesOptional = getById(moviesRequestDto.getId());
        if(moviesOptional.isPresent()){
            Movies movies = movieRepository.save(new Movies(moviesRequestDto));
            return new MoviesResponseDto(movies);
        }
        throw new Exception("filme nao atualizado");
    }

    public void delete(Integer id) throws Exception {
        Optional<Movies> moviesOptional = getById(id);
        if (moviesOptional.isPresent()) {
            movieRepository.delete(new Movies(id));
        }else{
            throw new Exception("filme nao encontrado");
        }
    }

    // vinculo de ator com filmes - many to many
}
