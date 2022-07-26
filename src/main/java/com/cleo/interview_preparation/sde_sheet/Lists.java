package com.cleo.interview_preparation.sde_sheet;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next=null;
    }
}

class LinkedList{

    public ListNode insert(ListNode root, int val){
        if(root==null)
            root = new ListNode(val);
        ListNode current = root;
        while(current.next!=null)
            current=current.next;
        current.next=new ListNode(val);
        return root;
    }
    public  boolean detectLoop(ListNode head){
        // Add code here
        ListNode hair = head,tortoise=head;
        while(tortoise.next.next!=null){
            tortoise=tortoise.next.next;
            hair=hair.next;
            if(tortoise==hair)
                return true;
        }
        return false;
    }
}
public class Lists {

    int count = 0;
    private ListNode head;

    public boolean detectLoop() {
        ListNode hare = head.next;
        ListNode tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public void removeLoop() {
        // code here
        // remove the loop without losing any ListNodes
        ListNode tortoise = head, hair = head.next;
        int count = 0;
        int length = 0;

        while (hair != tortoise) {
            if (hair.next == null || tortoise == null)
                break;
            tortoise = tortoise.next;
            hair = hair.next.next;
            count++;
        }
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (count >= length)
            return;
        current = head;
        for (int i = 0; i < count; i++) {
            current = current.next;
        }
        ListNode temp = current.next;
        temp = temp.next;
        current.next = temp;


    }

    public void insert(int val) {

        if (length() <= 0) {
            head = new ListNode(val);
            count += 1;

        } else {
            ListNode curr = head;
            while(curr.next!=null)
                curr=curr.next;
            curr.next= new ListNode(val);
            count++;

        }

    }


    public int length(){
       return count;
    }
    public void printList(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val + " ");
            current=current.next;
        }
        System.out.println();
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(0);
        ListNode current = merged;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
            }else {
                current.next=list2;
                list2=list2.next;
            }
        }
        if(list1!=null)
            current.next=list1;
        else if(list2!=null)
            current.next=list2;
        return merged.next;

    }
    public ListNode swapPairs(ListNode head) {
        ListNode swapped;
        if(head==null||head.next==null) {
            return head;
        }
        else{
            swapped=head.next;
            head.next=swapped.next;
            swapped.next=head;
            head = swapped;
            head.next.next=swapPairs(head.next.next);
            return head;
        }


    }
    public ListNode mergeTwoListsRecursive(ListNode head1, ListNode head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        ListNode head = new ListNode(0);
        if(head1.val<=head2.val){
            head=head1;
            head.next=mergeTwoListsRecursive(head1.next,head2);
        }else{
            head=head2;
            head.next=mergeTwoListsRecursive(head2.next,head1);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Lists l = new Lists();
        l.insert(1);
       l.insert(2);
      // l.insert(3);
       l.insert(4);
      //  l.printList();
        ListNode head2 = new ListNode(1);
        Lists list2 = new Lists();
        list2.insert(0);
        list2.insert(3);
        list2.insert(5);
        ListNode merged = new ListNode(0);
      //  Lists mergedList = new Lists();
        //merged=mergedList.mergeTwoLists(head,head2);
        //mergedList.printList(merged);
        ListNode swapped = l.swapPairs(head);
        l.printList(head);


    }


}
