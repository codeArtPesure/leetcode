package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Demo202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static  boolean isHappy(int n) {
        Set<Integer> set=new HashSet<Integer>();
        List<Integer> numbers=null;
        while (true){
            numbers=getNumbers(n);
            int sum=0;
            for (int i=0;i<numbers.size();i++){
                sum+=numbers.get(i)*numbers.get(i);
            }
            System.out.println(sum);
            if (sum==1){
                return true;
            }else if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
                n=sum;
            }
        }
    }

    //获得正整数的每一个位置上的数字
    public static List<Integer> getNumbers(int n){
        List<Integer> list=new ArrayList<Integer>();
        while (n!=0){
            list.add(n%10);
            n=n/10;
        }
        return list;
    }
}
