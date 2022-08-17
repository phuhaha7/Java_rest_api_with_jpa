package com.example.backend.teacher;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public void createNewTeacher(Teacher teacher) {
        Teacher teacher1 = Teacher.builder()
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .build();
        Optional<Teacher> teacher2 = teacherRepository.findByEmail(teacher1.getEmail());

        if (teacher2.isPresent()) {
            throw new IllegalStateException("email already exist");
        }
        teacherRepository.save(teacher1);
    }
}
