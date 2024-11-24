package com.cpifppiramide.animalitos.animalito.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Animalito {

    private Integer id;
    private String nombre;
    private String tipo;
    private Integer nivel;

    public Animalito(Integer id, Integer nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public Animalito(Integer id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
