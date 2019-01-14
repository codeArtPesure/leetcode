package com.dengzhili.Introduction;

import java.util.Random;

/**
 * 算法导论快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr=new int[15];
        Random random=new Random();
        for (int i=0;i<arr.length;i++){
            arr[i]=random.nextInt()%100;
        }
        QuickSort sort=new QuickSort();

        System.out.println("befort:");
        sort.printArr(arr);

        sort.quickSort(arr,0,arr.length-1);
        System.out.println("\n after:");
        sort.printArr(arr);

    }

    public void quickSort(int[] arr,int left,int right){
        if(left<right){
            int index=partition(arr,left,right);
            quickSort(arr,left,index-1);
            quickSort(arr,index+1,right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int position=arr[right];
        int i=left-1;
        int temp;
        for (int j=left;j<right;j++){
            if(arr[j]<=position){
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[right];
        arr[right]=arr[i+1];
        arr[i+1]=temp;
        return i+1;
    }


    public void printArr(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
