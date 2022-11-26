package com.wangpeijie.model;

import java.util.PriorityQueue;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/7
 */
public class Student implements Comparable<Student> {
    private String name;
    private int number;
    private int age;
    private int credit;

    public Student() {
    }

    public Student(String name, int number, int age, int credit) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", age=" + age +
                ", credit=" + credit +
                '}';
    }

    //重写equals
    @Override
    public boolean equals(Object obj) {
        // 自己和自己比较
        if (this == obj) {
            return true;
        }
        // obj如果是null对象，或者obj不是Card的子类
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        Student student=(Student) obj;
        if (!this.name.equals(student.name)||this.number!=student.number
                ||this.age!=student.age||this.credit!=this.credit){
            return false;

        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    //比较对象的某一个属性
    @Override
    public int compareTo(Student o) {
        return this.number-o.number;
    }
/*    @Override
    public int compareTo(Student o){
        return this.age-o.age;
    }
    */

}
