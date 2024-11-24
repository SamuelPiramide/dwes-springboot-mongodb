package com.cpifppiramide.animalitos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnimalitosApplicationTests {

	/*AnimalitosRepository animalitosRepository = new AnimalitosRepositoryMongoDB();
	AnimalitosUseCases animalitosUseCases = new AnimalitosUseCases(animalitosRepository);*/

	@Test
	void contextLoads() {
	}

	/*@BeforeAll()
	public static void clean(){
		MongoDBConnection.getDatabase().getCollection("animalitos").drop();
	}

	@Test
	public void save(){
		Animalito animalito = new Animalito("pepe");
		Animalito devolver = animalitosUseCases.save(animalito);
		assertEquals(devolver.getNombre(), animalito.getNombre());
	}

	@Test
	public void list(){
		MongoDBConnection.getDatabase().getCollection("animalitos").drop();
		animalitosUseCases.save(new Animalito("paco"));
		List<Animalito> animalitos = animalitosUseCases.getAll();
		assertEquals(1, animalitos.size());
	}*/

}
