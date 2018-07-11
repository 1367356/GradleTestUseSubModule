package com.li;

import org.junit.Test;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 最小的k个数。输入n个整数，找出最小的k个数。
 */
public class Question30 {

    /**
     * 方法1:使用快速排序中的partition方法，进行分割，这种方法要修改数组。
     */
    public void leastKNum(int[] numbers,int n,int k) {

        int start=0;
        int end=n-1;

        int index = partition(numbers, start, end);

        while (index != k - 1) {
            if (index > k - 1) {
                end=index-1;
                index = partition(numbers, start, end);
            }else {
                start=index+1;
                index = partition(numbers, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(numbers[i]);
        }
        return ;
    }

    private int partition(int[] numbers, int start, int end) {  //归并排序里面的
        int value = numbers[end];
        int j=start;
        for (int i = start; i <end; i++) {
            if (numbers[i] <= value) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j]=temp;
                j++;
            }
        }
        int temp=value;
        numbers[end]=numbers[j];
        numbers[j]=value;
        return j;

    }
    @Test
    public void test() {
        int[] arr={3, 2, 4, 5, 2, 1, 7};
        leastKNum(arr,arr.length,3);
    }

    /**
     * 方法2： 使用最大堆存储k个数，当新插入的数大于最大数时，不插入，小于最大数时，插入，将堆中的最大数删除
     */

    /**
     * 构建堆
     */
    class Heap{

        int parent(int i) {
            return i/2;
        }

        int leftChild(int i) {
            return 2*i;
        }

        int rightChild(int i) {
            return 2*i+1;
        }

        /**
         * 用数组模仿最大堆 ，维护最大堆的性质
         * @param x
         */
        public void maxHeapify(int [] A,int x) {
            int l = leftChild(x);
            int r = rightChild(x);
            int largest=x;
            if (l < A.length && A[l] > A[x]) {
                largest=l;
            }
            if (r < A.length && A[r] > A[largest]) {
                largest=r;
            }
            if (largest != x) {
                int swap = A[x];
                A[x] = A[largest];
                A[largest]=swap;
            }
            maxHeapify(A,largest);
        }

        /**
         *构建最大堆
         * @param A
         */
    public void bulidMaxHeapify(int[] A) {

        for (int i = A.length/2; i > 0; i++) {
            maxHeapify(A, i);
        }
    }

        public void deleteMaxValue(int[] A) {
            int max = A[0];
            A[0] = A[A.length - 1];
            int length=A.length-1;  //最大堆长度减1
            maxHeapify(A,0);
        }

    }


}
