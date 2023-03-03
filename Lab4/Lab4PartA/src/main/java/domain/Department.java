package domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Department() {

    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department( String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }

    @OneToMany(mappedBy = "department", cascade =CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Employee> employee=new ArrayList<Employee>();
}
