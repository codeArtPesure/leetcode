package com.dengzhili.leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Demo67 {


    public static void main(String[] args) {
        String a="1100";
        String b="110";
        String result=addBinary(a,b);
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        char[] arr1=a.toCharArray();
        char[] arr2=b.toCharArray();
        char[] result=null;
        int maxLength=0;
        if(arr1.length>arr2.length){
            maxLength=arr1.length;
            result=new char[maxLength+1];

            //初始化result数组
            for (int i = 0; i <arr2.length; i++) {
                result[maxLength-i]=arr2[arr2.length-1-i];
            }
            for (int i = 0; i <result.length-arr2.length; i++) {
                result[i]='0';
            }
            System.out.println(new String(result));
            return addBinaryWithResult(result,arr1);
        }else {
            maxLength=arr2.length;
            result=new char[maxLength+1];
            for (int i = 0; i <arr1.length; i++) {
                result[maxLength-i]=arr1[arr1.length-1-i];
            }
            for (int i = 0; i <result.length-arr1.length; i++) {
                result[i]='0';
            }
            System.out.println(new String(result));
            return addBinaryWithResult(result,arr2);
        }

    }

    /**
     * 将result与addend相加。结果保存到result（result.length-addend.length=1）
     * @param result
     * @param addend
     * @return
     */
    private static String addBinaryWithResult(char[] result,char[] addend){
        // '0' asci =48
        int offset=1;
        int addFlag=0;
        int tmp=0;
        for(int i=result.length-1;i>=1;i--){
            tmp=result[i]+addend[i-offset]-96+addFlag;
            if(tmp>=2){
                addFlag=1;
            }else {
                addFlag=0;
            }
            result[i]=(char)(tmp%2+48);
        }
        if(addFlag==1){
            result[0]='1';
            return new String(result);
        }else{
            return new String(result,1,result.length-1);
        }
    }

}
