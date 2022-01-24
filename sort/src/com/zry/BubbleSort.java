package com.zry;

/**
 * @author zry
 * @Date 2022/1/24
 * @ApiNote 冒泡排序，a表示数组，n表示数组大小
 * 思路：操作相邻的两个数据，每次操作都会对比相邻的两个元素，看是否满足大小关系，
 * 如果不满足就将其互换。
 * 一次冒泡会让至少一个元素移动到它应该在的位置，重复n次就完成了n个数据的排序
 * 优化：在某一次冒泡操作的时候若没有数据交换，则说明已经到达了完全有序，不用再次执行。
 *
 * 注意：
 * 冒泡排序的过程只涉及到相邻两个元素的交换操作，只需要常量级别的临时空间，所以空间复杂度为O(1)，是一个原地排序算法
 * 在冒泡中，只有交换才能改变两个元素的前后顺序，为了保证冒泡的稳定性，当有相邻的两个元素大小相同时，我们不做交换，相同大小的数据在排序前后顺序不会改变，所以冒泡是稳定排序
 * 最好的情况下，需要排序的数据已经是有序的了，我们只需要进行一次冒泡来确认是否有序，所以最好的时间复杂度是O(n)，而最坏的情况是要排序的数据刚好是倒序的，我们得进行n次冒泡、所以时间复杂度是O(n2)，而平均时间复杂度为O(n^2^)(太过繁琐，省略)
 *
 */
public class BubbleSort {
    public void bubbleSort(int[] a,int n){
        if (n<1){
            return;
        }
        for (int i = 0; i < n; i++) {
            //提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (a[j]>a[j+1]){
                    //交换位置
                    a[j+1] = (a[j]+a[j+1])-(a[j] = a[j+1]);
                    //有数据交换
                    flag = true;
                }
            }
            //没有数据交换，提前退出
            if (!flag){
                break;
            }
        }
    }
}
