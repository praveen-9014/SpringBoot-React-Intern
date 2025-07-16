package org.example;

public class Parent {


    public void EnterParentDetails(String Fname, String Mname, int siblingCount){
        System.out.println("Student father name is : " + Fname);
        System.out.println("Student mother name is : " + Mname);
        System.out.println(siblingCount + " Sibling");
        System.out.println("parent details entered Successfully");
        System.out.println();
    }

    public void parentDetails(){
        System.out.println("student's father name is : ABC");
        System.out.println("student's mother name is : xyz");
        System.out.println("2 Siblings");
        System.out.println();
    }
}
