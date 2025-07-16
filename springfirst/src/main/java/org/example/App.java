package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.beancontext.BeanContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext student = new ClassPathXmlApplicationContext("resources.xml");

        Student s = (Student) student.getBean("st");
        s.internShipProgram();

        SpringBoot sb = (SpringBoot) student.getBean("fun");

        sb.hello("hello");

    }
}
