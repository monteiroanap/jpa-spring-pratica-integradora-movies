package br.com.meli.movies1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "genres")
@Data
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

    @PrePersist
    public void setup(){
        this.createdAt = LocalDateTime.now();
        setupUpdatedAt();
    }

    public void setupUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }
}
