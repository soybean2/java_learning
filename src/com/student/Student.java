package com.student;

public class Student implements Comparable<Student>{
    private String stuName;
    private String stuNo;

    public Student() {
    }

    public Student(String stuNo,String stuName) {
        super();
        this.stuName = stuName;
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    @Override
    public String toString() {
        return "学生[姓名：" +
                 stuName +
                ",学号：" + stuNo +
                "]";
    }

    @Override
    public int compareTo(Student student) {
        int low = this.stuNo.compareTo(student.stuNo);
        return low == 0 ? this.stuName.compareTo(student.stuName):low;
    }
}
