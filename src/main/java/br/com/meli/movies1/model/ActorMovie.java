package br.com.meli.movies1.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "actor_movie")
@Data
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;



}
