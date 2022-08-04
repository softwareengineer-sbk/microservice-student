package self.training.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import self.training.app.model.StudentDBO;

@Repository
public interface StudentRepository extends JpaRepository<StudentDBO, Integer> {

}
