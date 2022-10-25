package br.com.meli.movies1.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
@Data
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "Decimal(3,1)")
    private Double rating;

    @Column
    private Integer awards;

    @Column(name = "release_date")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime releaseDate;

    @Column
    private Integer lenght;

    @ManyToOne
    @JoinColumn(name = "fk_genres", nullable = false)
    private Genres genres;

}
