package com.cpifppiramide.animalitos.animalito.domain;

public class AnimalitoDTO {
    private Integer id;
    private Integer nivel;

    public AnimalitoDTO(Integer id, Integer nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNivel() {
        return nivel;
    }
}
