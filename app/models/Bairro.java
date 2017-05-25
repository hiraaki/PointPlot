package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mhi on 25/05/17.
 */
@Entity
public class Bairro extends Model {
    @Id
    @GeneratedValue
    private double id;
    private String Nome;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
