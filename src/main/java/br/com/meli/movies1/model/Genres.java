package br.com.meli.movies1.model;

import br.com.meli.movies1.request_dto.GenresRequestDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column
    private Integer ranking;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "genres")
    private List<Movies> movies;
     //um genero pode estar em muitos filmes

    public Genres(Integer id) {
        this.id = id;
    }



    public Genres(GenresRequestDto genresRequestDto) {
        this.id = genresRequestDto.getId();
        this.name = genresRequestDto.getName();
        this.ranking = genresRequestDto.getRanking();
        this.active = genresRequestDto.isActive();
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    public void setup(){
        this.createdAt = LocalDateTime.now();
        setupUpdatedAt();
    }

    public void setupUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

}
