package self.training.app.service;

import self.training.app.dto.Student;

import java.util.List;

public interface StudentService {

    Student getById(int id);

    List<Student> getStudentsWithTeacherId(int teacherId);
}
