package com.example.Student.studentControllers;

import com.example.Student.studentModels.Student;
import com.example.Student.studentServices.studentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Student.studentRespositories.studentRespositories;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@RestController
@EnableAutoConfiguration
@CrossOrigin( origins = "http://localhost:3000")
@RequestMapping(path="/student")
public class studentController {


     @Autowired
     private studentRespositories studentRespo;
     @Autowired
     private studentServices services;


     public studentRespositories getStudentRespo() {
          return studentRespo;
     }

     @GetMapping
     public Iterable<Student> allStudent(){
          return studentRespo.findAll();  //query database
     }
     @GetMapping("/getData")
     public ResponseEntity<Student> getStudent(@RequestParam(name = "id" ,defaultValue = "") String IdStudent , @RequestParam(name = "name" , defaultValue = "") String name ){
          Student student = (Student) services.searchStudent(name,IdStudent);
          return ResponseEntity.ok(student);
     }

     @PostMapping("/import")
     public void  postStudent(@RequestParam("File")  MultipartFile excel ) throws ParseException, IOException {
              services.addValuetoVariable(excel);
     }
}
