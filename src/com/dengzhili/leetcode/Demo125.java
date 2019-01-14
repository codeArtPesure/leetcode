package com.dengzhili.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Demo125 {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

//        System.out.println(Character.isDigit('0'));
    }
    public static boolean isPalindrome(String s) {
        String letterString=getletterString(s);
        char[] arr=letterString.toCharArray();
        for(int i=0;i<arr.length/2;i++){
            int offset=arr[i]-arr[arr.length-1-i];
            if(Character.isLetter(arr[i]) && Character.isLetter(arr[arr.length-1-i])){
                if(offset==0 || offset==32 || offset==-32){
                    continue;
                }else {
                    return false;
                }
            }else if(offset!=0){
                return false;
            }
        }
        return true;
    }

    private static String getletterString(String s) {
        char[] arr=s.toCharArray();
        char[] resultArr=new char[arr.length];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(Character.isLetter(arr[i]) || Character.isDigit(arr[i])){
                resultArr[index]=arr[i];
                index++;
            }
        }
        return new String(resultArr,0,index);
    }
}
