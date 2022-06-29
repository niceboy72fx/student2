package com.example.Student.studentServices;

import com.example.Student.studentModels.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Student.studentRespositories.studentRespositories;
import org.springframework.util.NumberUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@Service
public class studentServices {
    @Autowired
    private studentRespositories studentRespo;

    public void addValuetoVariable(MultipartFile excel) throws ParseException{
        try {
            Workbook workbook = new XSSFWorkbook(excel.getInputStream());
            Sheet firstSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            for(int i = 5 ; i < firstSheet.getPhysicalNumberOfRows(); ++i){
                Row excelRow = firstSheet.getRow(i);
                Student student = new Student();

                student.setStt(Long.valueOf(fmt.formatCellValue(excelRow.getCell(0),evaluator)));
                student.setSchool(String.valueOf(excelRow.getCell(1)));
                student.setAddress(String.valueOf(excelRow.getCell(2)));
                student.setIdStudent(String.valueOf(excelRow.getCell(3)));
                student.setGrade(String.valueOf(excelRow.getCell(4)));
                student.setName(String.valueOf(excelRow.getCell(5)));
                SimpleDateFormat getDate = new SimpleDateFormat("dd/MM/yyyy");
                Date dateBirth = getDate.parse(excelRow.getCell(6) + "/" + excelRow.getCell(7) + "/" + excelRow.getCell(8));
                student.setBirthDate(dateBirth);
                student.setGender(String.valueOf(excelRow.getCell(9)));
                student.setProvince(fmt.formatCellValue(excelRow.getCell(10)));
                student.setDan_toc(fmt.formatCellValue(excelRow.getCell(11)));
                student.setAddress_live(fmt.formatCellValue(excelRow.getCell(12)));
                student.setPhone_num(fmt.formatCellValue(excelRow.getCell(13)));

                student.setClass1(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(14),evaluator)));
                student.setClass2(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(15),evaluator)));
                student.setClass3(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(16),evaluator)));
                student.setClass4(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(17),evaluator)));
                student.setClass5(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(18),evaluator)));

                student.setTotal5years(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(19),evaluator)));
                student.setPriorityPoint(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(20),evaluator)));
                student.setTotalPoint(Float.parseFloat(fmt.formatCellValue(excelRow.getCell(21),evaluator)));
                student.setWNote(fmt.formatCellValue(excelRow.getCell(22)));

                studentRespo.save(student);
            }
        } catch (FileNotFoundException e){
             e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Student> getStudentexcel(){
        return  studentRespo.findAll();
    }

    private String formatString(String str) {
        return str.toLowerCase().replaceAll("\\s+", " ").trim();
    }


    public Iterable<Student> searchStudent(String idStudent , String name){
          name = formatString(name);
          idStudent = formatString(idStudent);
          if (idStudent.equals("")){
              return studentRespo.findStudentByName(name);
          }
          return studentRespo.findStudentById(idStudent);
    }

}