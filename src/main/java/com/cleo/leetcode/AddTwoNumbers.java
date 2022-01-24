package com.cleo.leetcode;

import java.util.function.DoubleUnaryOperator;

class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {


    public static int reverse(int a){
            if(a == 0)
                return 0;

            else {
                return reverse(a / 10) + a % 10;
            }

    }
    ListNode head;
    public static ListNode reverse(ListNode a){
        if(a==null)
            return a;
        else{
          //  System.out.print(a.val);

            return reverse(a.next);
        }
    }
    public static void printList(ListNode x){
        while(x!=null) {
          System.out.print(x.val);
            x = x.next;
        }
        System.out.println();
    }
    /**
     *
     * @param l1 represents first number in linked list form
     * @param l2 represents second number in linked list form
     * @return the addition of the two numbers in linked list form
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode a1 = reverse(l1);
        while(a1.next!=null){
            System.out.print(a1.val);
        }
        System.out.println();
        int first=0;
        int second=0;
        int reversedFirst = 0, secondFirst =0;
        while(l1.next!=null){
            first = l1.val + first*10;
            l1 = l1.next;
        }

        while(l2.next!=null){
            second= l2.val + second*10;
            l2 = l2.next;
        }


        System.out.println(second);
        System.out.println(first + " " + second);
        int result = first + second;
        ListNode output = new ListNode(), root;
        root = output;
        boolean flag1 = true;
        while(result!=0){
            if(flag1){
                output.val = result%10;
                result/=10;
                root = output;
                flag1 = false;
                continue;
            }
            output.next = new ListNode(result%10);
            output= output.next;
            //output.val = result%10;
            result/=10;
            //output.next = new ListNode();
            //output = output.next;
        }

        //System.out.println("Output: " + output);


        return root;


    }

    public static ListNode addTwoNumbersV2(ListNode v1, ListNode v2){
        ListNode temp = v1;
      temp =  reverse(v1);
      //v2 = reverse(v2);
        System.out.println("Printing");
       printList( temp);
      //  System.out.println(v1.val);
        ListNode output = new ListNode(), root;
        root = output;
        int carry = 0, remainder=0;
        while(v1.next!=null && v2.next!=null) {
            int answer = v1.val + v2.val + carry;


            //output.val = v1.val + v2.val + carry;
            carry = answer %10;
            remainder = answer / 10;
            System.out.println("Carry= " + carry + " Remainder= " + remainder);
            output.val = remainder;


            v1 = v1.next;
            v2 = v2.next;
            output.next = new ListNode(carry);
            //System.out.print(output.val);
            output = output.next;

        }
            if(v1.next!=null){
                if(carry!=0)
                output.val = v1.val+carry;
                carry=0;
                v1 = v1.next;
                output.next = new ListNode();
                output = output.next;
            }
            if(v2.next!=null){
                if(carry!=0)
                output.val = v2.val+carry;
                carry=0;
                v2 = v2.next;
                output.next = new ListNode();
                output = output.next;
            }

        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(),l2 = new ListNode();
        ListNode root1 = l1, root=l2;
        int n = 3;
        int first = 249, second = 5649;
        while(first!=0){
            l1.val = first%10;
            System.out.print(l1.val);
            first/=10;
            l1.next = new ListNode();
            l1 = l1.next;
        }
        System.out.println();
        while(second!=0){

            l2.val = second%10;
            System.out.print(l2.val);
            second/=10;
            l2.next = new ListNode();
            l2 = l2.next;
        }
        System.out.println();
    //   System.out.println(l1.val + " " + l2.val);
        ListNode node = addTwoNumbersV2(root1,root);
        while(node.next!=null){
            System.out.print(node.val);
            node=node.next;
          //  root = root.next;
        }
        System.out.println();
        int reversed = reverse(123);
      //  System.out.println("Reversed 123=" + reversed);
    }
}
