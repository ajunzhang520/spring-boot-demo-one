package com.leetcode;

public class Num_206 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        for(int i = 2;i<4;i++){
            head.next = new ListNode(i);
            head = head.next;
        }

        System.out.println(head.val);


    }


    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
