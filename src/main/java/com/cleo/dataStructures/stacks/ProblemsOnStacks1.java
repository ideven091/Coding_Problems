package com.cleo.dataStructures.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ProblemsOnStacks1 {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> first = new Stack<>(), second = new Stack<>(), third = new Stack<>();
        int sum1=0,sum2=0,sum3=0;
       for(int c:h1){
           first.push(c);
       }
       for(int c:h2)
           second.push(c);
       for(int c:h3)
           third.push(c);

        int equal = 0;

        // FIXME: 23/01/22
        return equal;

    }
    static boolean ispar(String x)
    {
        // add your code here
        List<Character> opening = Arrays.asList('[', '(', '{');
        List<Character> closing = Arrays.asList(']',')','}');

        Stack<Character> stack = new Stack<>();
        for(char c: x.toCharArray()){
            if(c=='['||c=='{'||c=='(')
                stack.push(c);
            else if(c == ']'||c=='}'||c==')'){
                if(stack.isEmpty())
                    return false;
                char d = stack.peek();
                if(opening.indexOf(d)==closing.indexOf(c))
                    stack.pop();
                else
                    return false;
            }


        }
      //  System.out.println(stack.toString());
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String str = "{([])]";
        System.out.println(ispar(str));
    }
}
