package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 我们有一组排序的数字 D，它是  {'1','2','3','4','5','6','7','8','9'} 的非空子集。（请注意，'0' 不包括在内。）
 * <p>
 * 现在，我们用这些数字进行组合写数字，想用多少次就用多少次。
 * <p>
 * 例如 D = {'1','3','5'}，我们可以写出像 '13', '551', '1351315' 这样的数字。
 * <p>
 * 返回可以用 D 中的数字写出的小于或等于 N 的正整数的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：D = ["1","3","5","7"], N = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * 示例 2：
 * <p>
 * 输入：D = ["1","4","9"], N = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 */
public class Demo902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int numberDigit = getNumberDigit(N);  //整数N的位数

        String digitEmlemts = "";
        String numberStr = "" + N;

        for (String s : D) {
            digitEmlemts = digitEmlemts + s;
        }

        if (numberDigit == 1) {
            return getMostMinEquals(numberStr.charAt(0), digitEmlemts);
        }
        int total = 0;
        int elementSLength = digitEmlemts.length();
        int numberStrLen = numberStr.length();
        for (int i = 1; i < numberDigit; i++) {
            total = total + (int) Math.pow(elementSLength, i);
        }
        for (int i = 0; i < numberStrLen; i++) {
            char c = numberStr.charAt(i);
            int minIndex = getMostMin(c, digitEmlemts);
            if (minIndex == 0) {
                return total;
            }
            if (digitEmlemts.indexOf(c) == -1) {
                total += minIndex * Math.pow(elementSLength, numberStrLen - i - 1);
                return total;
            } else {
                if (i == numberStrLen - 1) {
                    total += minIndex * Math.pow(elementSLength, numberStrLen - i - 1);
                } else {
                    total += (minIndex - 1) * Math.pow(elementSLength, numberStrLen - i - 1);
                }
            }
        }
        return total;
    }

    /**
     * 返回number的位数  如100->3 1023->4
     *
     * @param number
     * @return
     */
    private int getNumberDigit(int number) {
        int n = 0;
        if (number < 0) {
            number = -number;
        }
        while (number != 0) {
            number = number / 10;
            n++;
        }
        return n;
    }

    /**
     * @param numberChar
     * @param str
     * @return
     */
    private int getMostMin(char numberChar, String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= numberChar) {
                continue;
            } else {
                return i;
            }
        }
        return str.length();
    }

    private int getMostMinEquals(char numberChar, String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= numberChar) {
                continue;
            } else {
                return i;
            }
        }
        return str.length();
    }
}

