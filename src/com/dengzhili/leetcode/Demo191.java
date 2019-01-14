package com.dengzhili.leetcode;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * 示例 :
 *
 * 输入: 11
 * 输出: 3
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 */
public class Demo191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
    public static int hammingWeight(int n) {
        /**
         * 每两位为一个单元，把原来单元中1的个数储存在原来的单元中
         */
         n=n-((n>>>1)&0x55555555);
        /**
         *0x33333333其实就是二进制……00110011（共32位），因为上面的每两位代表1的个数，所以下面的这几行就是要把上面每两位
         * 的数字加起来，下面的这行代码可以这样理解，每4位分为一组，然后4位中的每两位相加，相加的结果在储存到这4位二进制数中，
         * i & 0x33333333表示每4位中的低2位，(i >>> 2) & 0x33333333表示每4位中的高2位，然后在相加
         */
         n=(n&0x33333333)+(n>>>2&0x33333333);
        /**
         * 这个更好理解，i >>> 4表示往右移动了4位，然后在与i相加，相当于每8位一组，然后8位中的高4位与低4位相加储存在低4位中，
         * 然后这里在与0x0f0f0f0f进行与运算，把高4位完全置为0了，因为0x0f0f0f0f用二进制表示就是00001111000011110000111100001111，
         * 看到这里可能有些困惑，这里为什么要与0x0f0f0f0f进行与运算，因为每8位一组的话，最多也就是8，那么4位数足够了，高4位就没有必要了，
         * 如果不置为0有没有影响，其实如果1的位数极少的话是没什么影响的，但如果1的位数比较多到后面计算的结果可能就会往前进位，导致结果错误，
         * 所以这一步要进行一次与运算，那为什么上面的那行代码没有把4位一组中的高两位置0，这是因为4位一组最多有4个1，而2位二进制数最多表示3，
         * 小于4，所以不能置为0，
         *
         */
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        /**
         * 类似 每8位一组
         */
        n=(n+(n>>>8));
        /**
         * 类似 每16位一组
         */
        n=(n+(n>>>16));
        return n&0x3f;
    }
}
