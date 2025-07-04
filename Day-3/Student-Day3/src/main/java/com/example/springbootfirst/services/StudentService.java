package com.example.springbootfirst.services;


import com.example.springbootfirst.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    List<Student> studentDetails = new ArrayList<>(
            Arrays.asList(new Student(102 , "praveen", 20, "9014718812"), new Student(121,"sanjay", 19,  "8984739490"))
    );

    public List<Student> getStudentDetails(){
        return studentDetails;
    }

    public String studentName(){
        return "Student name is : Praveen";
    }

    public String studentAge(){
        return "Student Age is : 20";
    }

    public String studentMobileNumber(){
        return "Student Mobile Number is : 9014718812";
    }

    public Student getStudentById(int rollNo){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<studentDetails.size();i++){
            if(rollNo == studentDetails.get(i).getRollNumber()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            return studentDetails.get(ind);
        }
        else{
            return new Student();
        }
    }

    public String createStudent(Student student){
        studentDetails.add(student);

        return "student details is add successfully";
    }

    public String deleteStudent(int rollNo){
        int ind = 0;
        boolean flag = false;

        for(int i=0;i<studentDetails.size();i++){
            if(rollNo == studentDetails.get(i).getRollNumber()){
                ind = i;
                flag = true;
                break;
            }
        }

        if(flag){
            studentDetails.remove(ind);
            return "student is deleted succesfull";
        }
        else{
            return "Enter the correct rollnumber";
        }
    }

    public String updateStudent(Student student){
        int ind = 0;
        boolean flag = false;
        for(int i=0;i<studentDetails.size();i++){
            if(student.getRollNumber() == studentDetails.get(i).getRollNumber()){
                flag = true;
                ind = i;
                break;
            }
        }

        if(flag){
            studentDetails.set(ind, student);
            return "Student is Updated sucessfull";
        }
        else{
            return "Enter the correct RollNumber";
        }
    }
}
