package com.cpifppiramide.animalitos.animalito.application;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;

import java.util.List;

public class AnimalitosUseCases {

    private AnimalitoRepository animalitosRepository;

    public AnimalitosUseCases(AnimalitoRepository animalitosRepository){
        this.animalitosRepository = animalitosRepository;
    }

    public List<Animalito> getAll(){
        return this.animalitosRepository.getAll();
    }

    public Animalito findById(Integer id){
        return animalitosRepository.findById(id);
    }

    public List<Animalito> getAnimalitosPorTipo(String tipo){
        return animalitosRepository.getAnimalitosPorTipo(tipo);
    }


}
