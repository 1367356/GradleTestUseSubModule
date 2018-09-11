package com.li.chapter06;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 最大堆
 */
public class Heapify {

    public static void main(String[] args){
        Heapify heapify=new Heapify();
        int[] arr = {1,3,4,8,11,14};
//        int[] arr = {4, 3, 5};
        heapify.buildMaxHeapify(arr);
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
        System.out.println("堆排序");
        heapify.heapSort(arr);
        IntStream stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);
    }
    /**
     * 最大堆的角标值
     */
    public int parent(int i) {
        return (int) Math.floor(i / 2); //返回父节点的角标值
    }
    //左孩子
    public int leftChild(int i) {
        return 2*i+1;
    }
    //右孩子
    public int rightChild(int i) {
        return 2*i+2;
    }

    /**
     * 维护最大堆的性质,使用一个数组模仿最大堆
     */
    public void maxHeapify(int[] arr, int i) {
        int largest;
        int l = leftChild(i);
        int r = rightChild(i);
        if (l<arr.length&&arr[i] < arr[l]) {
            largest=l;
        }else {
            largest=i;
        }
        if (r<arr.length&&arr[largest] < arr[r]) {
            largest=r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest]=temp;
            maxHeapify(arr,largest);
        }
    }

    /**
     * 构建最大堆
     */
    public void buildMaxHeapify(int[] arr) {
        for (int i = arr.length/2-1; i >=0; i--) {
            maxHeapify(arr, i);
        }
    }

    /**
     * 堆排序算法
     */
    public void heapSort(int[] arr) {
        int heapSize=arr.length;
        buildMaxHeapify(arr);
        for (int i=arr.length/2;i>=1;i--) {
            int temp=arr[1];
            arr[1] = arr[i];
            arr[i]=temp;
            heapSize=heapSize-1;
            maxHeapify(arr,1);
        }
    }

    /**
     * 优先队列,最大值
     */
    public int heapMaximum(int[] arr) {
        return arr[1];
    }

    /**
     * 提取最大值之后的维护
     */
    public int heapExtractMax(int[] arr) {
        int heapSize=arr.length;
        if (arr.length < 1) {
            throw new IndexOutOfBoundsException("heap 堆溢出");
        }

        int max = arr[1];
        arr[1] = arr[arr.length - 1];
        heapSize=heapSize-1;
        maxHeapify(arr,1);
        return max;
    }

    /**
     * 第i个元素换为key
     */
    public void heapIncreaseKey(int[] arr, int i, int key) throws InterruptedException {
        if(key<arr[i]){
            throw new InterruptedException("新的key小于当前值");
        }
        arr[i]=key;
        while(i>1&&arr[parent(i)]<arr[i]){
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)]=temp;
            i = parent(i);
        }
    }
}
