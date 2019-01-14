package com.dengzhili.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class Demo119 {

    public List<Integer> getRow(int rowIndex) {

        int[][] yanghuiArr=new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            yanghuiArr[i][0]=1;
            yanghuiArr[i][i]=1;
        }
        for(int i=2;i<=rowIndex;i++){
            for(int j=1;j<=i;j++){
                yanghuiArr[i][j]=yanghuiArr[i-1][j-1]+yanghuiArr[i-1][j];
            }
        }
        List<Integer> list=new ArrayList<Integer>(rowIndex+1);
        for(int i=0;i<=rowIndex;i++){
            list.add(yanghuiArr[rowIndex][i]);
        }
        return list;
    }
}
