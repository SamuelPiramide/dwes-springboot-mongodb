package com.cpifppiramide.animalitos.animalito.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalitoRestController {

    AnimalitoRepository animalitoRepository;

    public AnimalitoRestController() {
        this.animalitoRepository = new AnimalitoRepositoryMySQL();
    }



    @GetMapping("/api/animalitos")
    public List<Animalito> animalitos(){

        return animalitoRepository.getAll();

    }

    @GetMapping("/api/animalitos/{id}")
    public Animalito animalitoId(@PathVariable Integer id){
        return animalitoRepository.findById(id);
    }
}
