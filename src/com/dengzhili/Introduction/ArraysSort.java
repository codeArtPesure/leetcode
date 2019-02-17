package com.dengzhili.Introduction;

import java.util.Arrays;

/**
 * 参照 arrays.sort(Object[]) 实现排序
 */
public class ArraysSort {

    //
    final static  Integer MIN_MERGE=32;

    public static void main(String[] args) {
        Integer[] arr={1,3,5,6,98,32,81,36,9};
        sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(Object[] arr,int startIndex,int endIndex){
        // 检查传入参数是否合法
        assert  arr!=null && startIndex>=0 && startIndex<=endIndex && endIndex <=arr.length;
        //计算排序区间
        int sortRemaining = endIndex -startIndex;
        //排序区间小于2 无需排序 直接返回
        if(sortRemaining<2){
            return;
        }
        if(sortRemaining<MIN_MERGE){
            //计算数组中有序子数组的长度，该处实际返回的是再分段情况下无序元素开始的索引
            int initRunLen=countRunAndMakeAscending(arr,startIndex,endIndex);
            System.out.println("initRunLen:"+initRunLen);
            binarySort(arr, startIndex, endIndex, startIndex + initRunLen);

        }
    }

    /**
     *
     * @param arr 需排序的数组
     * @param startIndex    开始排序的下标
     * @param endIndex      结束排序的下标
     * @param  initRunLen     无序排序元素的开始下标
     */
    private static void binarySort(Object[] arr, int startIndex, int endIndex, int initRunLen) {
        assert startIndex<=initRunLen && startIndex<=endIndex;
        if(initRunLen==startIndex){
            initRunLen++;
        }
        for(;initRunLen<endIndex;initRunLen++){
            Comparable pivot = (Comparable) arr[initRunLen];
            int left=startIndex;
            int right=initRunLen;
            while (left<right){
                // 该处计算出的是，从left开始到right的中间元素的下标,
                int mid = (left + right) >>> 1;
                //将无序元素与该次的中间值记性比较，
                // 如果当前的pivot的值小于中间值，则将right的坐标移动到中间下标.
                // 原因：因为从无序元素开始的initRunLen ,其左边已经处于升序状态，中间值比较,可以较少比较次数和比较范围

                if (pivot.compareTo(arr[mid]) < 0)
                    right = mid;
                else
                    left=mid+1;
            }
            int n = initRunLen - left;  // The number of elements to move
            // Switch is just an optimization for arraycopy in default case
            switch (n) {
                case 2:  arr[left + 2] = arr[left + 1];
                case 1:  arr[left + 1] = arr[left];
                break;
                default: System.arraycopy(arr, left, arr, left + 1, n);
            }
            arr[left] = pivot;
        }
    }


    /**
     * 计算数组中有序子数组的长度，该处实际返回的是再分段情况下无序元素开始的索引
     * @param arr   数组
     * @param startIndex  开始排序的元素下标
     * @param endIndex 结束数组下标
     * @return
     */
    private static int countRunAndMakeAscending(Object[] arr, int startIndex, int endIndex) {
        assert startIndex < endIndex;

        int run=startIndex+1;
        if(run == endIndex){
            return 1;
        }
        if (((Comparable) arr[run++]).compareTo(arr[startIndex]) < 0) { // Descending
            while (run < endIndex && ((Comparable) arr[run]).compareTo(arr[run - 1]) < 0)
                run++;
            //反转数组
//            reverseRange(a, lo, runHi);
        } else {                              // Ascending
            while (run < endIndex && ((Comparable) arr[run]).compareTo(arr[run - 1]) >= 0)
                run++;
        }
        return run - startIndex;
    }



}
