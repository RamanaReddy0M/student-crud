package in.one2n.ramana.services;

import in.one2n.ramana.entities.Student;
import in.one2n.ramana.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudentById(Long id){
        return Optional.of(studentRepository.getById(id));
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public boolean deleteStudentById(Long id){
        studentRepository.deleteById(id);
        return getStudentById(id).isEmpty();
    }
    public Student save(Student student){
        Student s = studentRepository.save(student);
        System.out.println(s);
        return student;
    }

    public List<Student> saveAll(List<Student> students){
        List<Student> studentList = studentRepository.saveAll(students);
        System.out.println(studentList);
        return studentList;
    }

}
