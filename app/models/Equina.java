package models;
import com.avaje.ebean.Model;
import javax.persistence.*;

/**
 * Created by mhi on 27/04/17.
 */
@Entity
public class Equina extends Model{
    @Id
    @GeneratedValue
    private double id;
    private Rua rua1;
    private Rua rua2;
    private Bairro bairro;
    private double longitude;
    private double latitude;

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public Rua getRua1() {
        return rua1;
    }

    public void setRua1(Rua rua1) {
        this.rua1 = rua1;
    }

    public Rua getRua2() {
        return rua2;
    }

    public void setRua2(Rua rua2) {
        this.rua2 = rua2;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
