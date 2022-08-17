package com.example.backend.teacher;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/teachers")
@AllArgsConstructor
@Slf4j
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public void createNewTeacher(@RequestBody Teacher teacher) {
        log.info("creating a new teacher");
        teacherService.createNewTeacher(teacher);
    }
}
