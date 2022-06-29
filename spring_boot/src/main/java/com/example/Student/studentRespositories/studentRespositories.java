package com.example.Student.studentRespositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Student.studentModels.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface studentRespositories extends  JpaRepository<Student,Long>{
//     Optional<Student> findStudent (String s);
     @Query ("select s from Student s where s.Name = :name")
     Iterable<Student>  findStudentByName(@Param("name") String name);
     @Query ("select s from Student s where s.IdStudent = :IdStudent")
     Iterable<Student> findStudentById(@Param("IdStudent") String IdStudent);
}



