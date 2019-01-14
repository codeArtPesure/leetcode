package com.dengzhili.Introduction;

import java.util.Random;

/**
 * 算法导论-计数排序
 */
public class CountingSort {


    public static void main(String[] args) {
        CountingSort sort=new CountingSort();
        int[] arr=sort.generateRandomArr(12,0,9);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nsort");
        int[] sortedArr=sort.countSort(arr,9);
        for(int i=0;i<arr.length;i++){
            System.out.print(sortedArr[i]+" ");
        }

    }

    public int[] countSort(int[] arr,int length){
        int[] result=new int[arr.length];
        //创建临时数组，并初始化为0
        int[] tempArr=new int[length];

        for(int i=0;i<tempArr.length;i++){
            tempArr[i]=0;
        }
        //遍历输入元素，记录元素出现的个数
        for(int j=0;j<arr.length;j++){
            tempArr[arr[j]]=tempArr[arr[j]]+1;
        }


        //记录了计数信息（有多少个元素是小于等于i的）
        for(int i=1;i<tempArr.length;i++){
            tempArr[i]=tempArr[i]+tempArr[i-1];
        }

        for(int i=arr.length-1;i>=0;i--){
            result[tempArr[arr[i]]-1]=arr[i];
            tempArr[arr[i]]=tempArr[arr[i]]-1;
        }
        return result;
    }

    public int[] generateRandomArr(int length,int min,int max){
        Random random=new Random();
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
           arr[i]=min+random.nextInt(max-min);
        }
        return  arr;
    }
}
