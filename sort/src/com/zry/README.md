# 排序

[TOC]

![image-20220124164613445](https://gitee.com/zhang_lai_yan/to-pic-go/raw/master/img/2022-01-24%2016-46-23_image-20220124164613445.png)

![image-20220125140645828](https://gitee.com/zhang_lai_yan/to-pic-go/raw/master/img/2022-01-25%2014-06-55_image-20220125140645828.png)

## 冒泡

思路：

操作相邻的两个数据，每次操作都会对比**相邻**的两个元素，看是否满足大小关系，

如果不满足就将其互换。

一次冒泡会让至少一个元素移动到它应该在的位置，**重复n次就完成了n个数据的排序**

---

优化：

**在某一次冒泡操作的时候若没有数据交换，则说明已经到达了完全有序，不用再次执行。**

---

注意：

- 冒泡排序的过程只涉及到相邻两个元素的交换操作，只需要常量级别的临时空间，所以空间复杂度为O(1)，是一个**原地排序算法**
- 在冒泡中，只有交换才能改变两个元素的前后顺序，为了保证冒泡的稳定性，当有相邻的两个元素大小相同时，我们不做交换，相同大小的数据在排序前后顺序不会改变，所以冒泡是**稳定排序算法**
- 最好的情况下，需要排序的数据已经是有序的了，我们只需要进行一次冒泡来确认是否有序，所以最好的时间复杂度是O(n)，而最坏的情况是要排序的数据刚好是倒序的，我们得进行n次冒泡、所以时间复杂度是O(n^2^)，而平均时间复杂度为O(n^2^)(太过繁琐，省略)

---

```java
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
```

## 插入

思路：

将数组中的数据分为两个区间，**已排序区间和未排序区间**。初始已排序区间中只有一个元素，就是数组中第一个元素。

插入算法的**核心思想**是**未排序区间的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。**

重复这个过程，直到未排序区间中元素为空，算法结束。

插入排序包括两种操作：元素比较、元素移动

当我们需要将一个数据a插入到已排序区间时，需要拿a与排序区间的元素依次比较大小，找到合适的插入位置。

找到插入点后，我们还需要将插入点之后的元素顺序往后移动一位，给a腾出位置。

---



注意：

插入排序并不需要额外的存储空间，所以**空间复杂度为O(1)**,也就是说，这是一个**原地排序算法。**

在插入排序中，如果碰到值相同的元素，我们可以选择将后面出现的元素插入到前面出现元素的后面，这样就可以保持原有的前后顺序不变，所以插入排序是**稳定排序算法**

如果要排序的数据是有序的，我们并不需要移动任何数据。如果我们从尾到头在有序区间中查找插入位置，每次只需要比较一个数据就能找到需要插入的位置。所以时间复杂度为O(n)

如果数据是倒序的，每次插入都相当于在已排序区间的第一个位置插入新的数据，所以需要移动很多数据，最坏的时间复杂度为O(n^2^).

对于插入排序来说，每次插入操作都需要相当于在数组中插入一个数据，循环执行n次插入操作，所以**平均时间复杂度为O(n^2^)**

---

```java
public class InsertionSort {
    /**
     * 插入排序
     * @param a 数组
     * @param n 数组大小
     */
    public void insertionSort(int[] a,int n){
        if (n<=1){
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i-1;
            //查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value){
                    //数据移动
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            //插入数据
            a[j+1] = value;
        }
    }
}
```

## 选择排序

注意：

选择排序空间复杂度为 O(1)，是一种**原地排序算法**。选择排序的最好情况时间复杂
度、最坏情况和平均情况时间复杂度都为 O(n^2^)

选择排序是一种**不稳定的排序算法**。选择排序每次都要找剩余未排序元素中的最小值，并和前面的元素交换位置，这样破坏了稳定性。

```java
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
```



---

## 通用的排序算法是什么样子的？

小规模数据可以使用O(n^2^)的算法，大规模数据可以使用O(nlogn)的算法

为了兼顾任意规模数据，我们一般==首选时间复杂度为O(nlogn)的排序算法==

那么，我们选择其中哪一个算法呢？

​	Java选择使用**堆排序**，C则使用**快速排序**。

快排在最坏情况下时间复杂度为O(n^2^)，我们给怎样对其进行优化呢？

### 如何优化快排

归根结底，主要原因还是因为我们**选择的分区点不够合理**。因为如果数据原本就是有序的，每次分区点若是选择最后一个数据，那么时间复杂度就会变成O(n^2^)。

**最理想的分区点：被分区点分开的两个分区，数据的数量差不多。**

#### 优化方法

1. ##### 三数取中法

    从分区首、未、中，分别取出一个数，然后对比大小，取这三个数的中间值作为分区点。

    但是若是数据量较大，则可能需要“五数取中”甚至更多

2. ##### 随机法

    在要排序的区间中，随机选择一个元素作为分区点。从概率上讲，不会太好也不会太差。

对于快排来说，实现底层用的是递归的方法，那么我们还需要解决**堆栈溢出**的问题。

1. 限制递归深度
2. 在堆上模拟实现一个函数调用栈，手动模拟递归出栈、压栈过程，这样就没有系统栈的限制了。