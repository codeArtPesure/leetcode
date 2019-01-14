package com.dengzhili.leetcode;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class Demo367 {

    /**
     * 方法一   完全平方数=1+3+5+7.... 判断num是否符合该性质
     *  结果：超时
     * @param num
     * @return
     */
//    public boolean isPerfectSquare(int num) {
//        int sum=0;
//        int i=1;
//        while (sum<num){
//            sum+=i;
//            i=i+2;
//        }
//        return sum==num;
//    }

    /**
     * 思路2：i从1开始不断计算i*i的值，判断与给定num的关系
     * 缺点：循环每次加1，执行次数过多
     * @param num
     * @return
     */
//    public boolean isPerfectSquare(int num) {
//        int i=1;
//        int sum=0;
//        while (true){
//            sum=i*i;
//            //sum<0 表示int类型已越界
//            if(sum>num || sum<0){
//                return false;
//            }
//            if(sum==num){
//                return true;
//            }
//            i++;
//        }
//    }

    /**
     * 思路3：二分法逼近
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {

        long end = 46350;
        long first = 0;
        long m = (end+first)/2;
        while(m*m!=num)
        {
            m = (end+first)/2;
            if((m*m<num)&&(num<(m+1)*(m+1)))
                return false;

            if(m*m>num)
            {
                end = m;
            }
            else if(m*m<num)
            {
                first = m;
            }

        }
        return true;
    }





}
