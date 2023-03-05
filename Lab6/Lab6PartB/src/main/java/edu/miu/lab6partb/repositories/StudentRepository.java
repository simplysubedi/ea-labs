package edu.miu.lab6partb.repositories;


import edu.miu.lab6partb.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
@Query("select  s from Student s where s.department.name=:department")
    List<Student> findAllByDepartment(String department);
@Query("select s from Student s join s.grade g where g.course.name=:course")
    List<Student>findALlStudentByCourse(String course);
}
