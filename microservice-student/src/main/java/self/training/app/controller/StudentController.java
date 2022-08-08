package self.training.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import self.training.app.configuration.ServerConfiguration;
import self.training.app.dto.Properties;
import self.training.app.dto.Student;
import self.training.app.service.StudentService;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final ServerConfiguration serverConfiguration;

    public StudentController(StudentService studentService, ServerConfiguration serverConfiguration){
        this.studentService = studentService;
        this.serverConfiguration = serverConfiguration;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public List<Student> getStudentsWithTeacherId(@RequestBody int teacherId){
        log.info("Controller method: getStudentsWithTeacherId");
        return studentService.getStudentsWithTeacherId(teacherId);
    }

    @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON)
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(serverConfiguration.getMsg(), serverConfiguration.getBuildVersion(), serverConfiguration.getMailDetails());
        return ow.writeValueAsString(properties);
    }
}
