package com.li.sortAlgorithm;

/**
 * @program: GradleTestUseSubModule
 * @author: Yafei Li
 * @create: 2018-09-08 08:36
 *  排序算法
 **/
public class Sort {

    /**
     * 选择排序是不稳定的
     * 选择排序：每次从剩余的数组中选择一个最小的数，依次放到前面的数组中（每次进行交换一次）。
     * @param arr
     */
    public void selectSort(int[] arr) {
        int mindex;
        for (int i = 0; i < arr.length-1; i++) {
            mindex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[mindex]) {
                    mindex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[mindex];
            arr[mindex]=temp;
        }
    }

    /**
     * 插入排序是稳定的
     * @param arr
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int index=i;
            while (arr[index] < arr[index - 1] && index > 0) {
                int temp=arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }


    public void quickSort(int[] arr,int low,int high) {
        if (low < high) {
            int middle = getMiddleIndex(arr, low, high);
            quickSort(arr, low, middle);
            quickSort(arr,middle+1,high);
        }
    }

    public int getMiddleIndex(int[] arr, int low, int high) {
        int temp = arr[high-1];
        int index=low;
        for (int i=low;i<high;i++) {
            if (arr[i] < temp) {
                int temp1 = arr[i];
                arr[i] = arr[index];
                arr[index]=temp1;
                index++;
            }
        }
        arr[high - 1] = arr[index];
        arr[index]=temp;
        return index;
    }


    /**
     * 堆排序
     */
    public void heapifySort(int[] arr,int i) {
        int l=2*i;
        int r=2*i+1;
        int largest=i;
        if (l < arr.length && arr[largest] < arr[l]) {
            largest=l;
        }
        if (r < arr.length && arr[largest] < arr[r]) {
            largest=r;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i]=temp;
            heapifySort(arr,largest);
        }
    }

    /**
     * 构建堆
     * @param arr
     */
    public void buildHeapify(int[] arr) {
        for (int i = arr.length/2; i>=0;i--) {
            heapifySort(arr,i);
        }
    }


    /**
     * 二分查找
     *
     */

    public int binarySearch(int[] arr,int value,int low,int high) {
            if (low > high) {
                return -1;
            }
            int middle=low+high;
            if (arr[middle] > value) {
                return binarySearch(arr, value, middle+1, high);
            } else if (arr[middle] < value) {
                return binarySearch(arr, value, low, middle);
            }else {
                return middle;
            }


    }



    public static void main(String[] args){
        int[] arrs = {1, 23, 34, 32, 1, 4};

        Sort sort=new Sort();
//        sort.insertSort(arrs);   //插入排序

//        sort.quickSort(arrs,0,arrs.length);  //快速排序
//        sort.buildHeapify(arrs);  //堆排序

        int i1 = sort.binarySearch(arrs, 32, 0, arrs.length-1);//二分查找
        System.out.println(i1);

        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }

    }
}
