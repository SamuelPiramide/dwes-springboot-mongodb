package com.cpifppiramide.animalitos.animalito.infrastructure;

import com.cpifppiramide.animalitos.animalito.domain.Animalito;
import com.cpifppiramide.animalitos.animalito.domain.AnimalitoRepository;
import com.cpifppiramide.animalitos.context.MySQLDBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalitoRepositoryMySQL implements AnimalitoRepository {
    @Override
    public List<Animalito> getAll() {
        List<Animalito> animalitos = new ArrayList<>();
        String sql = "select * from pokemones";
        try (Statement statement = MySQLDBConnection.getInstance().createStatement() ){
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Animalito animalito = new Animalito(rs.getInt("id"),rs.getString("nombre") ,rs.getString("tipo"));
                animalitos.add(animalito);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animalitos;
    }

    @Override
    public Animalito findById(Integer id) {
        Animalito animalito;
        String sql = "select * from pokemones where id = ?";
        try (PreparedStatement preparedStatement = MySQLDBConnection.getInstance().prepareStatement(sql)){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            animalito = new Animalito(rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animalito;
    }
}