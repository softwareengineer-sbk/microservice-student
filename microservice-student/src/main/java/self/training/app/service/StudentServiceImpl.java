package self.training.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import self.training.app.dto.Student;
import self.training.app.model.StudentDBO;
import self.training.app.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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

    @Override
    public List<Student> getStudentsWithTeacherId(int teacherId) {
        log.info("Service method: getStudentsWithTeacherId");
        List<StudentDBO> studentDBOS = studentRepository.findAllByTeacherId(teacherId);
        List<Student> students = new ArrayList<>(studentDBOS.size());
        studentDBOS.forEach(studentDBO -> {
            String name = studentDBO.getName();
            String dateOfBirth = studentDBO.getDateOfBirth();
            Student student = new Student(name, dateOfBirth);
            students.add(student);
        });
        return students;
    }
}
