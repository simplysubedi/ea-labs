package domain;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Passenger(String name) {

        this.name=name;
    }

    public Passenger() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="flight_id")
    @OrderColumn(name="sequence")
    private List<Flight> flights = new ArrayList<Flight>();

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
