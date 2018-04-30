package com.li;

/**
 * 数字在排序数组中出现的次数。
 */
public class Question38 {
    //得到起始点
    int getFirstK(int[] data, int length, int k,int start, int end) {
        if (start < end) {
            return -1;
        }

        int middleIndex=(start+end)/2;
        int middleData = data[middleIndex];

        if(middleData==k){
            if (middleIndex > 0 && data[middleIndex - 1] != k||middleIndex==0) {
                return middleIndex;
            }else {
                end=middleIndex-1;
            }
        } else if (middleData > k) {
            end=middleIndex-1;
        }else {
            start=middleIndex+1;
        }
        return getFirstK(data, length, k, start, end);
    }

    int getLastK(int[] data, int length, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex=(start+end)/2;
        int middleData = data[middleIndex];

        if (middleData ==k) {
            if (middleIndex == length - 1 && data[middleIndex + 1] != k || middleIndex == length - 1) {
                return middleIndex;
            }else {
                start=middleIndex+1;
            }
        } else if (middleData < k) {
            start=middleIndex+1;
        }else {
            end=middleIndex-1;
        }
        return getLastK(data, length, k, start, end);
    }

    public int getNumberOfK(int[] data, int length, int k) {
        int number=0;
        if (data != null && length > 0) {
            int first = getFirstK(data, length, k, 0, length - 1);
            int last = getLastK(data, length, k, 0, length - 1);
            if (first > -1 && last > -1) {
                number=last-first+1;
            }
        }
        return number;
    }
}
