package com.cleo.interview_preparation;

import java.util.Stack;

public class Stacks {
    int minEle;
    Stack<Integer> s = new Stack<>(),root=new Stack<>(),temp=new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        // Your code here
        return s.pop();
    }

    /*returns poped element from stack*/
    int pop()
    {
        // Your code here
        return s.peek();
    }

    /*push element x into the stack*/
    void push(int x)
    {
        // Your code here
        if(s.size()==0) {
            s = new Stack<>();
            s.push(x);
        }
        else if(x<s.peek()) {
            s.pop();
            s.push(x);
        }

    }

    public static void main(String[] args) {
        Stacks s = new Stacks();
        s.push(30);
        s.push(32);
        s.push(83);
        System.out.println(s.getMin());
    }
}
