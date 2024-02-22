package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;

    public Car() {

    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    @Override
    public String toString() {
        return "\nModel of car: " + model + "\nSeries: " + series;
    }
}
