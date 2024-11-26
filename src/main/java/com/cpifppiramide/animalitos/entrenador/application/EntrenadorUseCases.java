package com.cpifppiramide.animalitos.entrenador.application;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;


import java.util.ArrayList;
import java.util.List;

public class EntrenadorUseCases {

    EntrenadorRepository entrenadorRepository;
    AnimalitoRepository animalitosRepository;

    public EntrenadorUseCases(EntrenadorRepository entrenadorRepository, AnimalitoRepository animalitosRepository) {
        this.entrenadorRepository = entrenadorRepository;
        this.animalitosRepository = animalitosRepository;
    }

    public Entrenador save(Entrenador entrenador){
        String id = entrenadorRepository.save(entrenador);
        return entrenadorRepository.get(id);
    }

    public Entrenador saveCompleto(Entrenador entrenador){
        String id = entrenadorRepository.saveCompleto(entrenador);
        return entrenadorRepository.get(id);
    }


    public Entrenador getEntrenador(String id){
        Entrenador entrenador = entrenadorRepository.get(id);

        List<Animalito> animalitosEnteros = new ArrayList<>();

        entrenador.getCapturados().forEach(animalito -> {
            Animalito animalitoEntero = animalitosRepository.findById(animalito.getId());
            animalitoEntero.setNivel(animalito.getNivel());
            animalitosEnteros.add(animalitoEntero);
        });

        entrenador.setCapturados(animalitosEnteros);

        return entrenador;
    }

    public Entrenador captura(String idEntrenador, Animalito animalito){
        entrenadorRepository.captura(idEntrenador, animalito);
        return this.getEntrenador(idEntrenador);
    }


}
