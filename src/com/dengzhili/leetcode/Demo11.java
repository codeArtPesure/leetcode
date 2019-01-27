package com.dengzhili.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Demo11 {

    /**
     * 暴力法:O(n^2)  考虑每对可能出现的线段组合并找出这些情况之下的最大面积
     * @param height
     * @return
     */
//    public int maxArea(int[] height) {
//        int maxArea=0;
//        for (int i=0;i<height.length;i++){
//            for (int j=i+1;j<height.length;j++){
//                maxArea=Math.max(Math.min(height[i],height[j])*(j-i),maxArea);
//            }
//        }
//        return maxArea;
//    }

    /**
     * 双指针法：我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
     * 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，
     * 更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int maxArea=0;
        int start=0;
        int end=height.length-1;
        while (start<end){
            int area=Math.min(height[start],height[end])*(end-start);
            maxArea=Math.max(maxArea,area);
            if(height[start]<height[end]){
                start++;
            }else {
                end--;
            }
        }
        return maxArea;
    }

}
