package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School(String name) {
        this.name = name;
    }
    public School(){};
    @OneToMany(cascade= CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name="school_Id")
    @MapKey(name="studentId")
    private Map<Integer,Student> students = new HashMap<Integer,Student>();

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }
}
