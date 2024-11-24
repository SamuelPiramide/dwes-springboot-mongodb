package com.cpifppiramide.animalitos.entrenador.domain;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;

import java.util.List;

public class Entrenador {
    private String id;
    private String nombre;
    private List<Animalito> capturados;


    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador(String id, String nombre, List<Animalito> capturados) {
        this.id = id;
        this.nombre = nombre;
        this.capturados = capturados;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Animalito> getCapturados() {
        return capturados;
    }

    public void setCapturados(List<Animalito> capturados) {
        this.capturados = capturados;
    }
}
