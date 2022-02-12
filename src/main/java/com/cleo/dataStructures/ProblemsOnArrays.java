package com.cleo.dataStructures;


import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Interview "Arcesium"
 */
class Solution12 {
    public static long maximumSum(List<Long> a, long m) {
        // Write your code here
        long sum = 0, max = 0;
        List<Long> list = new ArrayList<>();
        for (var c : a) {
            list.add(c % m);
        }
        for (int i = 0; i < list.size()-1; i++) {

            sum = list.get(i)%m;
            if(max<=sum)
                max = sum;
            for (int j = i+1; j < list.size() ; j++) {
                sum+=list.get(j);
                sum%=m;
                if(max<=sum)
                    max = sum;

            }


        }

        return max;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/Test.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                long m = Long.parseLong(firstMultipleInput[1]);

                List<Long> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Long::parseLong)
                        .collect(toList());

                long result = maximumSum(a, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}


public class ProblemsOnArrays {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) % 5 != 0) {
                int answer = grades.get(i) % 5;
                if (answer >= 3)
                    if ((5 - answer) + grades.get(i) >= 40) {

                        //int answer = grades.get(i)%5;

                        grades.set(i, (5 - answer) + grades.get(i));
                    }
            }

        }
        return grades;

    }

   static int tour(int[] petrol, int[] distance) {
        // Your code here
        int index = -1, sum = 0, interval = 0;
        for (int i = 0; i < distance.length; i++) {
            if(interval<0) {
                interval = sum + (petrol[i] - distance[i]);
                if(interval>0)
                    index = i-1;
            }
           interval = petrol[i]-distance[i];
           if(interval<0) {
               sum += petrol[i];
              // index = i;
           }

        }
        return index;
    }
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
        int[] petrol ={1,4,4};
        int[] distance = {5,5,3};
        System.out.println(tour(petrol,distance));

    }
}
