package self.training.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import self.training.app.model.StudentDBO;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDBO, Integer> {

    List<StudentDBO> findAllByTeacherId(Integer teacherId);

}
