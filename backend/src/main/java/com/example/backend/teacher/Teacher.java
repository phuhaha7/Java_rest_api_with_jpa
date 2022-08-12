package com.example.backend.teacher;

import javax.persistence.*;

@Table(name = "teacher",
        uniqueConstraints = {@UniqueConstraint(
                name = "teacher_email_unique",
                columnNames = "email")})
@Entity(name = "teacher")
public class Teacher {
    @Column(name = "id", updatable = false)
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    @Column(name = "firstName", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastName;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;
}
