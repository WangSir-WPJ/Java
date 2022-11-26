package com.wangpeijie.model;

import java.util.Comparator;

/**
 * @Author 王珮杰
 * @DateTime 2022/11/17
 */
public class StudentCompareWithName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
