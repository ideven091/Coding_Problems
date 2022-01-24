package com.cleo;


import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ProblemsOnArrays {

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int sum = 0, height=0,width=0, max_sum=0;
        for (int i = 0; i < arr.size(); i++) {
            if(width+3<arr.size() && height+3<arr.get(height).size()) {
                for (int j = i; j < width + 3; j++) {
                    for (int k = 0; k < height+3; k++) {

                        sum+=arr.get(j).get(k);
                    }

                }
                if(max_sum<=sum)
                    max_sum=sum;
                sum = 0;

            }
            height+=1;width+=1;
        }
        return max_sum;

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        if(candles.size()==1)
            return 1;

        int max = -1, count = 1;
        for(int c: candles){
            if(max <c) {
                max = c;
                count=1;
            }else if(max == c){
                count++;
            }
        }
        return count;

    }
    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        int cost = 0;
        for(List<Integer> c:s){
            for(int d: c){
                       }
        }
       // int[] result = new int[9];
        return 0;
        // FIXME: 18/01/22 
        // TODO: 18/01/22  

    }

    public static void main(String[] args) throws IOException {
       List<Integer> arr = new ArrayList<>();
       arr.add(1);arr.add(2);arr.add(3);arr.add(3);
        System.out.println(birthdayCakeCandles(arr));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();


    }
}
