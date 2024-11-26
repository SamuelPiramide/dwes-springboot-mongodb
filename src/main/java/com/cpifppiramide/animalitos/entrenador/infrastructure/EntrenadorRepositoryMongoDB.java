package com.cpifppiramide.animalitos.entrenador.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.context.MongoDBConnection;
import com.cpifppiramide.animalitos.entrenador.domain.Entrenador;
import com.cpifppiramide.animalitos.entrenador.domain.EntrenadorRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

public class EntrenadorRepositoryMongoDB implements EntrenadorRepository {
    @Override
    public String save(Entrenador entrenador) {
        Document document = new Document();
        document.append("nombre", entrenador.getNombre());

        MongoCollection<Document> coleccion = MongoDBConnection.getDatabase().getCollection("entrenadores");
        InsertOneResult insertOneResult = coleccion.insertOne(document);

        ObjectId objectId = insertOneResult.getInsertedId().asObjectId().getValue();

        return objectId.toHexString();
    }

    @Override
    public String saveCompleto(Entrenador entrenador) {

        List<Document> animalitosDocs = entrenador.getCapturados().stream()
                .map(animalito -> new Document("id", animalito.getId())
                        .append("nivel", animalito.getNivel()))
                .collect(Collectors.toList());

        Document entrenadorDoc = new Document("id", entrenador.getId())
                .append("nombre", entrenador.getNombre())
                .append("capturados", animalitosDocs);

        MongoCollection<Document> coleccion = MongoDBConnection.getDatabase().getCollection("entrenadores");
        InsertOneResult insertOneResult = coleccion.insertOne(entrenadorDoc);


        return insertOneResult.getInsertedId().asObjectId().getValue().toHexString();
    }

    @Override
    public Entrenador get(String idEntrenador) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenadores");
        ObjectId entrenadorId = new ObjectId(idEntrenador);
        Document document = collection.find(eq("_id", entrenadorId)).first();

        String nombreEntrenador = document.getString("nombre");
        List<Document> animalitosDocument = (List<Document>) document.get("capturados");
        List<Animalito> animalitos = new ArrayList<>();

        if(animalitosDocument != null){
            animalitosDocument.forEach(animalito -> {
                animalitos.add(new Animalito(animalito.getInteger("id"),animalito.getInteger("nivel")));
            });
        }


        return new Entrenador(idEntrenador,nombreEntrenador,animalitos);
    }

    @Override
    public void captura(String idEntrenador, Animalito animalito) {
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("entrenadores");
        ObjectId id = new ObjectId(idEntrenador);
        Document document = new Document();
        document.put("id",animalito.getId());
        document.put("nivel", animalito.getNivel());
        Bson update = Updates.push("capturados", document);
        collection.findOneAndUpdate(eq("_id", id),update);
    }
}
