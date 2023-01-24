package com.example.projuct_crud;

public class Model_Table {
    String Student_ID,Name,Index_Num,Course,Mobile,Hall;


    public Model_Table(String student_ID, String name, String index_Num, String course, String mobile, String hall) {

        Student_ID = student_ID;
        Name = name;
        Index_Num = index_Num;
        Course = course;
        Mobile = mobile;
        Hall = hall;
    }

    public Model_Table() {

    }


    public String getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(String student_ID) {
        Student_ID = student_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIndex_Num() {
        return Index_Num;
    }

    public void setIndex_Num(String index_Num) {
        Index_Num = index_Num;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getHall() {
        return Hall;
    }

    public void setHall(String hall) {
        Hall = hall;
    }
}
