package com.cleo.interview_preparation;



import java.util.ArrayList;
import java.util.List;

class Pair{
    int start;
    int end;

    public String toString(){
        return start + " " + end;
    }
}

public class Arrays1 {

    public static void rotate(int[] arr, int n) {
        if(n==1)
            return;
        int temp1 = arr[0],temp2 = arr[n-1];
        arr[0]=temp2;

        for (int i = 1; i < n; i++) {
            temp2 = arr[i];
            arr[i]=temp1;
            temp1 = temp2;


        }

    }

    /**
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * @param nums Given a list of integers
     * @param target find 4 numbers in the list
     * @return such that sum of the numbers is equal to the target
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        nums = java.util.Arrays.stream(nums).sorted().toArray();





        return list;

    }

    public static int binarySearch(int[] nums, int first, int last,int value){
        if(first>=last)
            return first;
        int mid = (first+last)/2;
     //   System.out.println(mid);
        if(nums[mid]>value)
           return binarySearch(nums,first,mid-1,value);
        if(nums[mid]==value)
            return mid;
        return binarySearch(nums,mid+1,last,value);
    }

    public static int searchInsert(int[] nums, int target) {
        int value = binarySearch(nums,0,nums.length,target);
       // System.out.println(value);
        if(value>nums.length-1)
            return nums.length;
        if(value<=0)
            return 0;
        if(nums[value]==target)
            return value+1;
        else if(nums[value]<target)
            return value+2;
        else
            return value-2;


    }
    long maxProduct(int[] nums, int n) {
        // code here
        long neg = 1;
        long pos = 1;
        long maxProduct = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                neg = 1;
                pos = 1;
                maxProduct = Math.max(maxProduct, 0);
            } else if (nums[i] < 0) {
                long temp = pos;
                if (neg < 0) {
                    pos = neg * nums[i];
                    maxProduct = Math.max(pos, maxProduct);
                } else {
                    pos = 1;
                }
                neg = temp * nums[i];
            } else {
                if (neg < 0) {
                    neg *= nums[i];
                }
                pos *= nums[i];
                maxProduct = Math.max(pos, maxProduct);
            }
        }
        return maxProduct;
    }

    static ArrayList<Integer> subarraySum(int[] input, int n, int sum)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int currentSum = 0;
       Pair p = new Pair();
        p.start = 0;
        for(int i=0; i < input.length; i++){
            currentSum += input[i];
            p.end = i;
            if(currentSum == sum){
                list.add(p.start+1);
                list.add(p.end+1);
                return list;
            }else if(currentSum > sum){
                int s = p.start;
                while(currentSum  > sum){
                    currentSum -= input[s];
                    s++;
                }
                p.start = s;
                if(currentSum == sum){
                    list.add(p.start+1);
                    list.add(p.end+1);
                    return list;
                }
            }
        }
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        int[] A = {9, 8, 7, 6, 4, 2, 1, 3};
        int[] B = {1,2,3,7,5};
        int[] C = {1,2,3,4,5,6,7,8,9,10};int K = C.length;int S = 15;
        int M = B.length;
        int N = 8;
        //rotate(A,N);
        //System.out.println(java.util.Arrays.toString(A));
        //System.out.println(getMinMax(A,N));
        System.out.println(subarraySum(A,N,21));
        System.out.println(subarraySum(B,M,14));
        System.out.println(subarraySum(C,K,15));
        int[] arr = new int[]{1,2,4,7,9};
        System.out.println(searchInsert(arr,0));

    }
}
