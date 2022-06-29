package com.example.Student.studentModels;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="student")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
     // cai nay dung hibernate
    private Long Stt;
    private String school,address,IdStudent,Grade,Name;
    private Date BirthDate;
    private String Gender,Province,dan_toc,Address_live,phone_num;

    private double class1,class2,class3,class4,class5 , total5years;
    @Column(nullable = true)
    private double priorityPoint = 0.0;
    private double totalPoint;

    private String WNote;


}
