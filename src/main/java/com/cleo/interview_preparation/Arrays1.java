package com.cleo.interview_preparation;



import java.util.*;

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

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        int carry = 0;

        if(digits[n-1]==9)
            carry=1;
        else{
            digits[n-1]+=1;
            return digits;
        }
        for (int i = n-1; i >0 ; i--) {
            if(digits[i]==9&&carry==1) {
                digits[i] = 0;
              carry=1;
            }else if(carry==1&&digits[i]!=9){
                digits[i]+=1;
                carry=0;
            }else{
                digits[i]=digits[i];
            }
        }
        int[] answer = new int[n+1];
        if(carry!=1)
            return digits;
        if(carry==1){
            if(digits[0]!=9) {
                digits[0] += 1;
                return digits;
            }
            else {

                digits[0] = 0;


                answer[0]=1;
                for (int i = 1; i < n; i++) {
                    answer[i]=digits[i-1];

                }

            }
        }
        return answer;



    }
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < N; i++) {
            if(A[i]!=B[i])
                return false;
        }
        return true;
    }
    public static long minValue(long[] a, long[] b, long n)
    {
        // Your code goes here
        Arrays.sort(a);
        Arrays.sort(b);
        long n1 = a[a.length-1];
        long n2 = b[b.length-1];
        long min1 = 0,min=0;

            for (int i = 0; i < n; i++) {
                min1+=a[i]*b[b.length-i-1];
            }
        for (int i = 0; i < n; i++) {
            min+=a[a.length-i-1]*b[i];
        }

    //    System.out.println(min+"\t"+min1);
        return min1;

    }
    int maxLen(int arr[], int n)
    {
        // Your code here
       HashMap<Integer,Integer> map = new LinkedHashMap<>();
        int length=0;
        for (int e:arr) {

            map.compute(e,(k,v)->v==null?1:++v);

        }
        System.out.println(map.entrySet());
        return maxSubarrayLength(arr,n,map);
    }
    int maxSubarrayLength(int[] arr,int n,Map<Integer,Integer> map){
        if(map.get(n-1)==0)
            return n;
        return 1;
    }
  static   void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        if(k==1)
            return;
        // code here
        int j=0;
        ArrayList<Integer> answer = new ArrayList<>();
        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            j = i+k;
            if(j<n){
                 s = arr.stream()
                        .limit(k)
                        .sorted(Collections.reverseOrder())
                        .toList();
                ;
                answer.addAll(s);
                i = i+k;
            }else{
                j = n-i-1;
                s = arr.stream()
                        .sorted(Collections.reverseOrder())
                        .toList();
                answer.addAll(s);
                i +=n-j;
            }
            System.out.println(i);
        }
       arr = answer;
      System.out.println(answer);
    }

    static void reverse(ArrayList<Integer> arr,int start, int end){
        int temp=0;
        for (int j = start; j < (start + end)/2; j++) {
            temp = arr.get(j);
            arr.set(j, arr.get(end-j));
            arr.set(end-j, temp);
            System.out.println(arr);
        }
    }

    static void reverseInGroupsV2(ArrayList<Integer> arr, int n, int k){

        //ArrayList<Integer> temp = new ArrayList<Integer>();
        int index = k-1,j=0;
        int temp = 0;
        int i=0;
        for (i = 0; i < n; i++) {

            if(index<n) {
              reverse(arr,i,index);
                index=i+k;
                j+=k;
            }
            i+=k;
        }
        System.out.println(j+ " ");
        if(index<=n){
           // m = j;
      //      temp.addAll(arr.subList(j,n).stream().sorted().toList());
            reverse(arr,index,n);

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
        nums = Arrays.stream(nums).sorted().toArray();





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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        System.out.println();
        reverseInGroupsV2(list,5,3);
        System.out.println(list);
        long[] x =  {6, 1, 9, 5, 4};
        long[] y = {3, 4, 8, 2, 4};
        int[] a = new int[]{1};
        Arrays.sort(a);
        System.out.println(check(x,y,3));
        System.out.println(Arrays.toString(a));
        System.out.println(minValue(x,y,x.length));
        Arrays1 arrays1 = new Arrays1();
        int[] max = {15,-2,2,-8,1,7,10,23};
        System.out.println(arrays1.maxLen(max,max.length));
        System.out.println(Arrays.toString(plusOne(new int[]{1,9,8})));

    }
}
