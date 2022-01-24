package com.zry;

/**
 * @author zry
 * @Date 2022/1/24
 * @ApiNote
 */
public class SelectSort {
    public void selectSort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            // 将当前下标定义为最小值下标
            int flag = i;
            for (int j = i + 1; j < a.length; j++) {
                // a[j] < temp 从小到大排序；a[j] > temp 从大到小排序
                if (a[j] < temp) {
                    temp = a[j];
                    // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                    flag = j;
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }
}