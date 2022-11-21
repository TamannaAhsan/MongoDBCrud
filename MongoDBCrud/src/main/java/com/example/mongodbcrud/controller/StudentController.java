package com.example.mongodbcrud.controller;

import com.example.mongodbcrud.domain.Book;
import com.example.mongodbcrud.domain.Student;
import com.example.mongodbcrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student student1 = studentService.create(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        Book book1 = studentService.createBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> all = studentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable String id) {
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable String id) {
        Student student1 = studentService.update(student, id);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete (@PathVariable String id){
        studentService.delete(id);
        Map<String, String> message = Map.of("message", "Student Deleted Successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
