package com.dengzhili.leetcode;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * 示例 1：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 */
public class Demo859 {

    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        char[] charArr1=A.toCharArray();
        char[] charArr2=B.toCharArray();
        if(A.equals(B)){
            int[] lettersCount=new int[26];
            for(int i=0;i<charArr1.length;i++){
                lettersCount[charArr1[i]-'a']=lettersCount[charArr1[i]-'a']+1;
            }
            for(int i=0;i<lettersCount.length;i++){
                if(lettersCount[i]>=2){
                    return true;
                }
            }
            return false;
        }
        // 记录不相等的字母长度(若长度超过3，直接返回false)
        int[] arr=new int[3];
        int arrIndex=0;
        for(int i=0;i<A.length();i++){
            if(charArr1[i]!=charArr2[i]){
                if(arrIndex==2){
                    return false;
                }
                arr[arrIndex]=i;
                arrIndex++;
            }
        }
        if(arrIndex!=2){
            return false;
        }
        if(charArr1[arr[0]]==charArr2[arr[1]] && charArr1[arr[1]]==charArr2[arr[0]]){
            return true;
        }
        return false;
    }

}
