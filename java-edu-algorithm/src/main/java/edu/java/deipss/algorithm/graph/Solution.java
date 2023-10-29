package edu.java.deipss.algorithm.graph;


import java.util.Arrays;


class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {

        int [] ans = new int[nums2.length];

        int [][] indexArr = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            indexArr[i][0]=nums2[i];
            indexArr[i][1]=i;
        }
        Arrays.sort(nums1);
        Arrays.sort(indexArr, (a,b)->b[0]-a[0]);
        int left = 0;
        int right = nums2.length;
        for (int i = 0; i < indexArr.length; i++) {
            if(nums1[left]>indexArr[i][0]){
                ans[indexArr[i][1]]=nums1[left];
                ++left;
            }else{
                ans[indexArr[i][1]]=nums1[right];
                --right;
            }

        }
        return ans;
    }

}