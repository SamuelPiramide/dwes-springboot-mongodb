package com.cpifppiramide.animalitos.animalito.infrastructure;

import com.cpifppiramide.animalitos.animalito.application.AnimalitosUseCases;
import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalitoRestController {

    AnimalitosUseCases animalitosUseCases;

    public AnimalitoRestController() {
        this.animalitosUseCases = new AnimalitosUseCases(new AnimalitoRepositoryMySQL());
    }

    @GetMapping("/api/animalitos")
    public List<Animalito> animalitos(){
        return animalitosUseCases.getAll();
    }

    @GetMapping("/api/animalitos/{id}")
    public Animalito animalitoId(@PathVariable Integer id){
        return animalitosUseCases.findById(id);
    }


    @GetMapping(value = "/api/animalitostipo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Animalito> pokemonListTipo(@RequestBody String json){
        //SE NECESITA IMPORTAR EN EL POM LA DEPENDENCIA DE JSON PARA USARLO
        JSONObject jsonAnimalito = new JSONObject(json);
        String tipo = jsonAnimalito.getString("tipo");
        return animalitosUseCases.getAnimalitosPorTipo(tipo);
    }
}
