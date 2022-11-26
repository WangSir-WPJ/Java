package com.wangpeijie.arraylist;

/**
 * @Author 王珮杰
 * @DateTime 2022/10/18
 */
public class arrayList1 {
    private Object[] Array = new Object[10];

    public void setArray(int pos, Object val) {
        Array[pos] = val;
    }

    public Object getArray(int pos) {
        return Array[pos];
    }
}
