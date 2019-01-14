package com.dengzhili.Introduction;

import java.util.Random;

/**
 * 算法导论（快速排序的随机版本）
 */
public class RandomQuickSort {

    public static void main(String[] args) {
        int[] arr=new int[15];
        Random random=new Random();
        for (int i=0;i<arr.length;i++){
            arr[i]=random.nextInt()%100;
        }
        RandomQuickSort sort=new RandomQuickSort();

        System.out.println("befort:");
        sort.printArr(arr);

        sort.randomizedSort(arr,0,arr.length-1);
        System.out.println("\n after:");
        sort.printArr(arr);
    }

    public void randomizedSort(int[] arr,int left,int right){
        if(left<right){
            int index=randomedPartition(arr,left,right);
            randomizedSort(arr,left,index-1);
            randomizedSort(arr,index+1,right);
        }
    }

    public int randomedPartition(int[] arr,int left,int right){
        int randomIndex=getRandomIndex(left,right);
        int temp;
        temp=arr[right];
        arr[right]=arr[randomIndex];
        arr[randomIndex]=temp;
//
//        int positionNumber=arr[right];
//
//        int j=left-1;
//
//        for (int i=left;i<right;i++){
//            if(arr[i]<=positionNumber){
//                j++;
//                temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
//            }
//        }
//        temp=arr[right];
//        arr[right]=arr[j+1];
//        arr[j+1]=temp;
//        return j+1;
        int position=arr[right];
        int i=left-1;
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

    private int getRandomIndex(int left, int right) {
        Random random=new Random();
        int randomNumber=left+Math.abs(random.nextInt()%(right-left));
        return randomNumber;
    }

    public void printArr(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
