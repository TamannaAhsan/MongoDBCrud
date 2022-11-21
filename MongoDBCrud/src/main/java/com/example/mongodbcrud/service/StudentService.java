package com.example.mongodbcrud.service;

import com.example.mongodbcrud.domain.Book;
import com.example.mongodbcrud.domain.Student;
import com.example.mongodbcrud.repository.BookRepository;
import com.example.mongodbcrud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final BookRepository bookRepository;

    public Student create (Student student){
        student.setJoinDate(LocalDate.now());
        return studentRepository.save(student);
    }

    public List<Student> getAll (){
        List<Student> all = studentRepository.findAll();
        return all;
    }
    public Student update (Student student, String id) {
        Student student1 = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));

            student1.setName(student.getName());
            student1.setClassRecord(student.getClassRecord());
            student1.setEmail(student.getEmail());
            student1.setClassRecord(student.getClassRecord());
            student1.setJoinDate(student.getJoinDate());
            return studentRepository.save(student1);
    }

    public void delete (String id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
        studentRepository.deleteById(id);
    }

    public Student getById (String id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));
        return student;
    }

    public Book createBook (Book book){
        return bookRepository.save(book);
    }
}
