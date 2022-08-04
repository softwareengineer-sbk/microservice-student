package self.training.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "student")
public class StudentDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "teacher_id")
    private Integer teacherId;
}
