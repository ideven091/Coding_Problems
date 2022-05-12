package com.cleo.revision.school;

public class BinFlip {

    public static void binaryString(String str){
        String temp = "";
        int count = 0;
        int counter = 1;
        for(char c: str.toCharArray()){
            if(count==2)
                break;
            temp+=c;

            count++;
            counter = 2;
        }
    }
}
