package com.cpifppiramide.animalitos.entrenador.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.cpifppiramide.animalitos.animalito.infrastructure.AnimalitoRepositoryMySQL;
import com.cpifppiramide.animalitos.entrenador.application.EntrenadorUseCases;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntrenadorRestController {

    EntrenadorUseCases entrenadorUseCases;

    public EntrenadorRestController() {
        EntrenadorRepository entrenadorRepository= new EntrenadorRepositoryMongoDB();
        AnimalitoRepository animalitoRepository = new AnimalitoRepositoryMySQL();
        this.entrenadorUseCases = new EntrenadorUseCases(entrenadorRepository,animalitoRepository);
    }

    @GetMapping("/api/entrenador/{id}")
    public Entrenador get(@PathVariable String id){
        return this.entrenadorUseCases.getEntrenador(id);
    }

    @PostMapping("/api/entrenador")
    public Entrenador save(@RequestBody Entrenador entrenador){
        return this.entrenadorUseCases.save(entrenador);
    }

    @PutMapping(value = "/api/entrenador/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Entrenador captura(@PathVariable String id, @RequestBody String json){

        //SE NECESITA IMPORTAR EN EL POM LA DEPENDENCIA DE JSON PARA USARLO
        JSONObject jsonAnimalito = new JSONObject(json);
        Animalito animalito = new Animalito(jsonAnimalito.getInt("id"), jsonAnimalito.getInt("nivel"));
        return this.entrenadorUseCases.captura(id, animalito);
    }

    @PostMapping(value = "/api/entrenadorcompleto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Entrenador saveCompleto( @RequestBody Entrenador entrenador){
        return entrenadorUseCases.saveCompleto(entrenador);
    }


}
