package com.cleo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


//BackTracking
public class AllPossiblePermutations {

    List<List<Integer>> answer = new ArrayList<>();
    private int count;

    public void permute(int[] nums, int left, int right){
        if(left==right){

            List<Integer> temp = new ArrayList<>();
            for(int c: nums){
                temp.add(c);
            }
            if(!answer.contains(temp))
                answer.add(temp);


        }else {
            for (int i = left; i <=right; i++) {
                nums = swap(nums, i, left);
                permute(nums, left + 1, right);
                nums = swap(nums, i, left);
            }
        }
    }
    public int[] swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
        return nums;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if(n==1){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            answer.add(temp);
            return answer;
        }

        permute(nums,0,nums.length-1);
        return answer;
      }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        AllPossiblePermutations possiblePermutations = new AllPossiblePermutations();
        possiblePermutations.permute(nums);
        for(var c: possiblePermutations.answer){
            System.out.print(c+ " ");
        }
    }

}
