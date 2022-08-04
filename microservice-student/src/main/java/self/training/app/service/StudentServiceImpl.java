package self.training.app.service;

import org.springframework.stereotype.Service;
import self.training.app.dto.Student;
import self.training.app.model.StudentDBO;
import self.training.app.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getById(int id) {
        Optional<StudentDBO> studentDBO = studentRepository.findById(id);
        Student student = new Student();
        if (studentDBO.isPresent()){
            student.setName(studentDBO.get().getName());
            student.setDateOfBirth(studentDBO.get().getDateOfBirth());
        }
        return student;
    }
}
