package com.cpifppiramide.animalitos.entrenador.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoDTO;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.cpifppiramide.animalitos.animalito.infrastructure.AnimalitoRepositoryMySQL;
import com.cpifppiramide.animalitos.entrenador.application.EntrenadorUseCases;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;
import org.bson.json.JsonObject;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(entrenador.getNombre());
        return this.entrenadorUseCases.save(entrenador);
    }

    @PutMapping("/api/entrenador/{id}")
    public Entrenador captura(@PathVariable String id, @RequestBody AnimalitoDTO animalitoDTO){

        Animalito animalito = new Animalito(animalitoDTO.getId(), animalitoDTO.getNivel());
        return this.entrenadorUseCases.captura(id, animalito);
    }
}
