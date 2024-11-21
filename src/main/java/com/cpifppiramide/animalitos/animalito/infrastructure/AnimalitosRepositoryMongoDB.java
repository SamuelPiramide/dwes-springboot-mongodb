package com.cpifppiramide.animalitos.animalito.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitosRepository;
import com.cpifppiramide.animalitos.context.MongoDBConnection;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnimalitosRepositoryMongoDB implements AnimalitosRepository {
    @Override
    public String save(Animalito animalito) {
        Document document = new Document();
        document.append("nombre", animalito.getNombre());
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("animalitos");
        InsertOneResult insertOneResult = collection.insertOne(document);
        ObjectId id = Objects.requireNonNull(insertOneResult.getInsertedId()).asObjectId().getValue();
        return id.toHexString();
    }

    @Override
    public List<Animalito> getAll() {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("animalitos");
        List<Animalito> animalitos = new ArrayList<>();
        for (Document document : collection.find()) {
            System.out.println(document.toJson());
            String nombre = document.getString("nombre");
            animalitos.add(new Animalito(nombre));
        }
        return animalitos;
    }

    @Override
    public Animalito findById(String id) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("animalitos");
        ObjectId idAnimalito = new ObjectId(id);
        Bson bsonAnimal = new Document("_id", idAnimalito);
        Document document = collection.find((bsonAnimal)).first();
        if (document != null) {
            String nombre = document.getString("nombre");
            return new Animalito(nombre);
        } else {
            return null;
        }
    }
}
