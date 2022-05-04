package in.one2n.ramana.controllers;

import in.one2n.ramana.entities.Gender;
import in.one2n.ramana.entities.Student;
import in.one2n.ramana.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/hi")
    public String sayHello(){
        return "hello!";
    }

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get")
    public ResponseEntity<String> getStudentById(@RequestParam Long id){
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> new ResponseEntity<>(value.toString(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("No student found with id: " + id, HttpStatus.BAD_REQUEST));
    }


    @GetMapping("/delete")
    public ResponseEntity<String> deleteStudentById(@RequestParam Long id){
       if(studentService.deleteStudentById(id))
           return new ResponseEntity<>(HttpStatus.OK);
       else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/load")
    public ResponseEntity<List<Student>> load(){
        Student s1 = new Student("Alaric Saltsmen", Date.valueOf("1992-09-08"), Gender.M, "alaric@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));

        Student s2 = new Student("Haley", Date.valueOf("1999-02-03"), Gender.F, "haley@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));

        Student s3 = new Student("Matt Donavon", Date.valueOf("1998-07-08"), Gender.M, "matt@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));

        Student s4 = new Student("PaPa Tinde", Date.valueOf("1991-04-01"), Gender.M, "tinde@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));

        Student s5 = new Student("Turner", Date.valueOf("1990-03-03"), Gender.M, "turner@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));

        List<Student> students = studentService.saveAll(List.of(s1, s2, s3, s4, s5));
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/load-one")
    public ResponseEntity<Student> loadOne(){
        Student s = new Student("Vincent", Date.valueOf("1997-04-27"), Gender.M, "vincent@gamil.com",
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ),
                LocalDateTime.of(2022, 05, 03, 6, 58, 10 ));
        return new ResponseEntity<>(studentService.save(s), HttpStatus.OK);
    }
}
