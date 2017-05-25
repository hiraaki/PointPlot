package models;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by mhi on 27/04/17.
 */
@Entity
public class Rua extends Model{
    @Id
    @GeneratedValue
    private int id;

    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
