package com.wangpeijie.model;

import java.util.Comparator;

/**
 * 定义多个比较规则,可根据场景需要，进行选择
 * @Author 王珮杰
 * @DateTime 2022/11/17
 */

public class StudentCompareWithAge implements Comparator<Student> {
    //按年龄去排列
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }

}
