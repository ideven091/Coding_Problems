package com.cleo.leetcode.medium;



public class AddTwoNumbers {

    private static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        public ListNode(int data) {
            this.data = data;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node, root;
        int sum1 = 0, i = 0, sum2 = 0 ,carry = 0;
        while (l1 != null) {
            sum1 += Math.pow(10,i++)*  l1.data;
            l1 = l1.next;

        }
        i = 0;
        while(l2!=null) {
            sum2 += Math.pow(10,i++)*l2.data;
            l2 = l2.next;

        }
        System.out.println(sum1 + " " + sum2);
        sum1 = sum1+sum2;
        System.out.println(sum1);
        boolean flag = false;
        node = new ListNode(sum1%10);
        int num = sum1%10;
        sum1/=10;
        root = node;


        while(sum1!=0){

            num = num + sum1%10;

            node.next = new ListNode(sum1%10);
            sum1/=10;
            node = node.next;
        }

        return root;

    }

    public static ListNode addTwoNumbersV2(ListNode l1, ListNode l2){
        ListNode answer = new ListNode(0), root = new ListNode(0);
        int sum = 0,result=0, carry = 0;
        boolean flag = true, flag1=false, flag2 = false;

        while(true){
            if(l1==null&&l2==null)
                break;
            if(flag){
                sum = l1.data+l2.data;
                result = sum%10;
                carry = sum/10;
                answer = new ListNode(result);
                System.out.println(answer.data);
                root = answer;
                flag = false;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            if (l1 == null && l2 != null) {
                flag1 = true;
                break;
            }
            if (l1 != null && l2 == null) {
                flag2 = true;
                break;
            }
            else {
                sum = l1.data + l2.data + carry;
                result = sum % 10;
                carry = sum / 10;
                answer.next = new ListNode(result);

                answer = answer.next;
                l1 = l1.next;
                l2 = l2.next;


            }
            System.out.print(answer.data);

        }
        if(flag1){
         while(l2!=null){
             sum = l2.data + result;
             result = sum%10;
             carry = sum/10;
             answer.next= new ListNode(carry);
             l2 = l2.next;
             answer = answer.next;
             System.out.println(answer.data);
         }
        }
        if(flag2){
            while(l1!=null){
           //     System.out.println(l1.data);
                sum = l1.data + carry;
                result = sum%10;
                carry = sum/10;
                answer.next = new ListNode(result);
                l1 = l1.next;
                answer = answer.next;
             //   System.out.println(answer.data);
            }
        }
        if(carry!=0) {
            answer.next = new ListNode(carry);
            answer = answer.next;
        }
        return root;
    }



    public static void main(String[] args) {
        ListNode root1, root2;
        ListNode first = new ListNode(9);
        root1 = first;
        first.next = new ListNode(9);
        first = first.next;
       /* root1 = first;
        first.next = new ListNode(9);
        first = first.next;
        first.next = new ListNode(9);
        first = first.next;
        first.next = new ListNode(9);
        first = first.next;
        first.next = new ListNode(9);
        first = first.next;
        first.next = new ListNode(9);
        first = first.next;
        first.next = new ListNode(9);
        first = first.next;
*/


        ListNode second = new ListNode(9);
        root2 = second;
        /*
        second.next = new ListNode(9);
        second = second.next;
        second.next = new ListNode(9);
        second = second.next;
        second.next = new ListNode(9);
        second = second.next;
*/
        ListNode root = addTwoNumbersV2(root1, root2);
        while(root!=null){
            System.out.print(root.data + " ");
            root = root.next;
        }

    }
}
