package com.dengzhili.leetcode;

/**
 * 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 *
 * 输入：
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 *
 * 注意：
 *
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 */
public class Demo443 {

    public int compress(char[] chars) {
        int[] charArr=new int[127];
        for(char c:chars){
            charArr[c]++;
        }
        int len=0;
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]==0) {
                continue;
            }else {
                len=len+1+getDigits(charArr[i]);
            }
        }
        return len;
    }

    /**
     * 获得数字的位个数  如120有3位  12有2位
     * @param number
     * @return
     */
    private int getDigits(int number){
        int digits=0;
        while (number!=0){
            number=number/10;
            digits++;
        }
        return digits;
    }

}
