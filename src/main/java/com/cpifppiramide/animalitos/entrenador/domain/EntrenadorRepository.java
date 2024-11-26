package com.cpifppiramide.animalitos.entrenador.domain;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;

public interface EntrenadorRepository {

    String save(Entrenador entrenador);
    String saveCompleto(Entrenador entrenador);
    Entrenador get(String id);
    void captura(String id, Animalito animalito);
}