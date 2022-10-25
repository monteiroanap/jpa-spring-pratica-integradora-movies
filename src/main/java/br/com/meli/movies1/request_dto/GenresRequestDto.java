package br.com.meli.movies1.request_dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class GenresRequestDto implements Serializable {

   @NotNull
    private String name;

    @NotNull
    private Integer ranking;

    @NotNull
    private boolean active;
}
