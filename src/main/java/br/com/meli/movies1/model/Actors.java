package br.com.meli.movies1.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "actors")
@Data
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(columnDefinition = "Decimal(3,1)")
    private Double rating;

}
