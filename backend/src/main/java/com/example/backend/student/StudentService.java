package com.example.backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> s = studentRepository.findStudentByEmail(student.getEmail());
        if (s.isPresent()) {
            throw new RuntimeException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);
        if (!exist) {
            throw new RuntimeException("Student is not in record");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, String firstName, String lastName, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Student with " + id + " does not exist."));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> s = studentRepository.findStudentByEmail(email);
            if (s.isPresent()) {
                throw new RuntimeException("Email taken.");
            }
            student.setEmail(email);
        }
    }
}
