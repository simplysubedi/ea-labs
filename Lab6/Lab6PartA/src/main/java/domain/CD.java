package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="CD.findBYArtistName",query="select cd from CD cd where cd.artist=:name")
public class CD extends Product{

    private String artist;



    public CD(String name, String description, double price, String artist) {
        super(name, description, price);
        this.artist = artist;
    }

    public CD() {

    }

    @Override
    public String toString() {
        return super.toString()+"CD{" +
                "artist='" + artist + '\'' +
                '}';
    }
}
