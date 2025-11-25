package com.example.demo.controller;
import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentRepository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// AssertJ for fluent assertions
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
// Indicates this is a Spring Boot test that loads the full application context
@SpringBootTest
// Specifies the order in which test methods will be executed
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerTest {
// Injects the StudentRepository bean from the Spring context
@Autowired
private StudentRepository studentRepository;
// First test: verifies that a student can be saved to the repository

@Test
@Order(1) 
void shouldSaveStudent() {
Student student = new Student();
student.setName("Charlie");
student.setAddress("Algeria");

// Save the student to the H2 in-memory database
studentRepository.save(student);
// Assert that the repository now contains exactly one record
assertThat(studentRepository.count()).isEqualTo(1);
}
}
