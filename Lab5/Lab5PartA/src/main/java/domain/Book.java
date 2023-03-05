package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book  extends Product{

    private int isbn;
}
