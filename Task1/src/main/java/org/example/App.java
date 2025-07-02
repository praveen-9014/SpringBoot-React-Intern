package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");

        Student s1 = (Student) context.getBean("student");

        s1.TotalStudents();
        s1.EnterStudentDetails("praveen", "praveen901471@gmail.com", 20);
        s1.studentDetails();

        Parent p1 = (Parent) context.getBean("parent");
        p1.EnterParentDetails("abc", "xyz", 2);
        p1.parentDetails();

        Teacher t1 = (Teacher) context.getBean("teacher");
        t1.teacherDetails();
    }
}
