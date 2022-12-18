package com.student;

import java.util.*;

public class StudentManage {


        private HashMap<String, Student> stuMap = new HashMap<String, Student>();
        private Scanner input = new Scanner(System.in);

    public StudentManage() {
        if (stuMap == null)
        {
            stuMap = new HashMap<String, Student>();
            input = new Scanner(System.in);
        }
    }
    public void init(){
        add(new Student("12345678","张三"));
        add(new Student("12345679","李四"));
        add(new Student("12345680","王五"));
        System.out.println("学生信息列表为：");
        showAll();
    }
    public void menu(){
        System.out.println("=========学生管理系统==========");
        System.out.println("1、添加学生");
        System.out.println("2、删除学生");
        System.out.println("3、修改学生信息");
        System.out.println("4、查看学生信息");
        System.out.println("5、显示所有信息");
        System.out.println("6、退出系统");
        System.out.println("============================");
        System.out.println("请选择1~6");
    }

    public void run(){
        while(true){
            menu();
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    changeStudent();
                    break;
                case 4:
                    quaryStudent();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    input.close();
                    System.out.println("系统退出");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public void addStudent() {
        System.out.println("请输入要添加学生的信息");
        Student student = new Student();
        newStudent(student);
        
        if(add(student)){
            System.out.println("添加成功");
            System.out.println(student);
        }else{
            System.out.println("添加失败");
        }
    }

    public void newStudent(Student student) {
        String string ="";
        boolean ok = false;
        do {
            System.out.print("\t学号:");
            string = input.next();
            System.out.println("输入的学号是:" + string);
            if (string.matches("[\\d][9]")) {
                student.setStuNo(string);
                ok = true;
            } else {
                System.out.println("error: 学号必须为9位数字\n请道新输入:");
                continue;
            }
            System.out.print("\t姓名:");
            string = input.next();
            student.setStuName(string);
            ok = true;
        }while (!ok);
    }

    private boolean add(Student student) {
        String stuNo = student.getStuNo();
        if (stuMap.containsKey(stuNo)) {
            return false;
        } else {
            stuMap.put(stuNo, student);
            return true;
        }
    }

    public void deleteStudent() {
        System.out.print("请输入要删除的学号:");
        String stuNo = input.next();
        Student student = remove(stuNo);
        if (student == null) {
            System.out.println("不存在该联系人!");
        } else {
            System.out.println(student);
        }
        System.out.println("学生删除成功!");
        getAll();
    }
    private Student remove(String stuNo){
            return stuMap.remove(stuNo);
    }

    public void changeStudent() {
        System.out.print("请输入英恪改学号:");
        String str = input.next();
        Student student = query(str);
        if (student == null) {
            System.out.println("不存在谈学生");
            return;
        }
        System.out.print("请输入要修改的学生姓名:");
        String stuName = input.next();
        student.setStuName(stuName);
        update(str, student);
        System.out.println("恪改成功");
        System.out.println(student);
    }
    private void update(String stuNo, Student student) {
        stuMap.remove(stuNo);
        stuMap.put(student.getStuNo(), student);
    }

    public void quaryStudent() {
        System.out.print("请输入要查看学生的学号:");
        String str = input.next();
        Student stu = query(str);
        if (stu == null)
            System.out.println("不存在该学生");
        else System.out.println(stu);

        }
    private Student query(String stuNo) {
        if (stuMap.containsKey(stuNo))
            return stuMap.get(stuNo);
        else return null;
    }
    public void showAll() {
        List<Student> list = getAll();
        Collections.sort((List<Student>) list);
        System.out.println("======================");
        System.out.println("总共" + list.size() + "条信息");
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println();
    }


    public List<Student> getAll() {
        List<Student> lists = new ArrayList<Student>();
        Set<String> sets = stuMap.keySet();
        for (String str : sets) {
            lists.add(stuMap.get(str));
        }
        return lists;
    }

}
