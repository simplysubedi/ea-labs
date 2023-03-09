package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Student {
    @Id

  private String studentNumber;
  private String name;
   private String phone;
    private Address address;
private List<Grade> grade;
    public Student( String name, String phone, Address address) {

        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }

//    public Student(String studentNumber, String name, String phone, Address address, List<Grade> grade) {
//        this.studentNumber = studentNumber;
//        this.name = name;
//        this.phone = phone;
//        this.address = address;
//        this.grade = grade;
//    }
    @Override
    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", grade=" + grade +
                '}';
    }
}
