package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Demo118 {

    public List<List<Integer>> generate(int numRows) {

        int[][] yanghuiArr=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            yanghuiArr[i][0]=1;
            yanghuiArr[i][i]=1;
        }
        for(int i=2;i<numRows;i++){
            for(int j=1;j<=i;j++){
                yanghuiArr[i][j]=yanghuiArr[i-1][j-1]+yanghuiArr[i-1][j];
            }
        }
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int i = 0; i <numRows; i++) {
            List<Integer> list=new ArrayList(i+1);
            for(int j=0;j<=i;j++){
                list.add(yanghuiArr[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
