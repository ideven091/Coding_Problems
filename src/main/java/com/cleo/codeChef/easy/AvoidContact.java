package com.cleo.codeChef.easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AvoidContact {

    public static int numberOfRooms(int total, int infected){
        if(infected==0)
            return total;

       if(infected==total)
           return infected+total-1;
       else
           return infected+total;

    }


    public static void main(String[] args) throws java.lang.Exception {
       try{
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int T = Integer.parseInt(reader.readLine());
           while (T-- > 0) {
               String[] s = (reader.readLine().split(" "));
               int people = Integer.parseInt(s[0]);


               int infected = Integer.parseInt(s[1]);
               System.out.println(numberOfRooms(people,infected));
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
