package com.cpifppiramide.animalitos.animalito.domain;

import java.util.List;

public interface AnimalitosRepository {

     String save(Animalito animalito);
     List<Animalito> getAll();
     Animalito findById(String id);

}
