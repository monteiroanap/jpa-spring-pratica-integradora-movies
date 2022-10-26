package br.com.meli.movies1.response_dto;

import br.com.meli.movies1.model.Genres;
import lombok.Getter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class GenresResponseDto implements Serializable {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private Integer ranking;
    private boolean active;

    public GenresResponseDto(Genres genres) {
        this.id = genres.getId();
        this.createdAt = genres.getCreatedAt();
        this.updatedAt = genres.getUpdatedAt();
        this.name = genres.getName();
        this.ranking = genres.getRanking();
        this.active = genres.isActive();
    }
}
