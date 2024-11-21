package com.cpifppiramide.animalitos.animalito.application;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;

import java.util.List;

public class AnimalitosUseCases {

    private AnimalitosRepository animalitosRepository;

    public AnimalitosUseCases(AnimalitosRepository animalitosRepository){
        this.animalitosRepository = animalitosRepository;
    }

    public Animalito save(Animalito animalito){
        String id = this.animalitosRepository.save(animalito);
        return this.animalitosRepository.findById(id);
    }

    public List<Animalito> getAll(){
        return this.animalitosRepository.getAll();
    }

}
