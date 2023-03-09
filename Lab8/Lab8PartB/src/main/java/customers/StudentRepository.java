package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {

    List<Student> findByName(String name);

List<Student>findByPhone(String phone);
    @Query("{'address.city' : :#{#city}}")
    List<Student>findByCity(String city);

    @Query("{'grade':{$elemMatch: {'courseName': :#{#courseName}}}}")

    List<Student> findByCourseName(String courseName);
@Query("{'grade': {$elemMatch: {'courseName': :#{#courseName},'grade':'A+'}}}")
    List<Student> findByGrade(String courseName);
}
