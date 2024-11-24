package com.cpifppiramide.animalitos.animalito.domain;

import java.util.List;

public interface AnimalitoRepository {

     List<Animalito> getAll();
     Animalito findById(Integer id);

}
