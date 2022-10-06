package ru.ivanovds.leetcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index >= 0 ? index : -index-1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1); // sentinel
        ListNode ptr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        while (l1 != null) {
            ptr.next = l1;
            ptr = ptr.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            ptr.next = l2;
            ptr = ptr.next;
            l2 = l2.next;
        }

        return dummy.next;
    }

    public boolean isValidSudoku(char[][] board) {
        final int MAXZIP = 99999;
        BitSet b = new BitSet(MAXZIP + 1);
        b.set(0, MAXZIP, false);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1};

//        System.out.println(solution.searchInsert(nums, 1));
}

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
