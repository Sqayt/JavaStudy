package ru.ivanovds.leetcode.easy;

import java.util.*;

public class Solution {

    public int findFinalValue(int[] nums, int original) {
        boolean isFound = false;

        while(!isFound) {
            isFound = true;
            for (Integer num: nums) {
                if (original == num) {
                    original *= 2;
                    isFound = false;
                    break;
                }
            }
        }

        return original;
    }

    public int countPrefixes(String[] words, String s) {
        int count = 0;
        for (String value : words) {
            String word;
            if (value.length() > s.length()) {
                word = s;
            } else {
                word = String.valueOf(s.subSequence(0, value.length()));
            }

            if (word.equals(value)) {
                count++;
            }
        }

        return count;
    }

    public int removePalindromeSub(String s) {
        return 0;
    }

    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int differenceOfSum(int[] nums) {
        int esum = 0, dsum = 0;
        for (int i : nums) {
            esum += i;
            for (int j = i; j > 0; j/= 10)
                dsum += (j % 10);
        }
        return Math.abs(dsum-esum);

    }

    public String interpret(String command) {
        if(command.isBlank() || command.length()==1){
            return command;
        }

        StringBuilder sb = new StringBuilder();
        int length = command.length();
        for(int i= 0; i < length; i++){
            char c = command.charAt(i);
            if(c =='G'){
                sb.append('G');
            }else if(c=='(' && i<length-1&& command.charAt(i+1)==')'){
                sb.append("o");
                i++;
            }else{
                sb.append("al");
                i+=3;
            }
        }
        return sb.toString();
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public List<List<Integer>> generate(int numRows) {
        int n = numRows;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevList = null; // temp for prev row

        // for each row
        for (int r = 1; r <= n; r++) {
            List<Integer> list = new ArrayList<>();

            // for each col
            for (int c = 1; c <= r; c++) {
                // first and last item, print 1
                if (c == 1 || c == r) {
                    list.add(1);
                } else {
                    // for the middle items, we get from the prev row
                    list.add(prevList.get(c - 2) + prevList.get(c - 1));
                }
            }

            result.add(list);
            prevList = list;
        }


        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head != null) {
            return head;
        }
        ListNode node = head;
        ListNode prev = null;
        ListNode reversed = null;

        while (node != null) {
            final ListNode next = node.next;

            if (node.next == null) {
                reversed = node;
            }

            node.next = prev;
            prev = node;
            node = next;
        }

        return reversed;
    }

    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];


        for (int i = 0; i < leftSum.length; i++) {
            leftSum[i] = sumLeft(i, nums);
            rightSum[i] = sumRight(i, nums);
        }

        int[] array = new int[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return array;
    }

    public int sumLeft(int i, int[] array) {
        int tmp = 0;
        for (int j = 0; j < i; j++) {
            tmp += array[j];
        }

        return tmp;
    }

    public int sumRight(int i, int[] array) {
        int tmp = 0;
        for (int j = array.length - 1; j > i ; j--) {
            tmp += array[j];
        }

        return tmp;
    }

    public int deepestLeavesSum(TreeNode root) {
        int res = 0, i;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            for (i = q.size() - 1, res = 0; i >= 0; --i) {
                TreeNode node = q.poll();
                res += node.val;
                if (node.right != null) q.add(node.right);
                if (node.left  != null) q.add(node.left);
            }
        }
        return res;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = result.get(i);
        }

        return target;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int tmp = 0;
        for (int i = 0; i < m; i++, tmp++) {
            result[i] = nums1[i];
        }

        for (int i = tmp; i < n + m; i++) {
            result[i] = nums2[i - tmp];
        }
        
        Arrays.sort(result);
        nums1 = result;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverseInOrder(root, result);

        return result;
    }

    public void traverseInOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            traverseInOrder(node.left, res);
            res.add(node.val);
            traverseInOrder(node.right, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(new TreeNode(
                1,
                null,
                new TreeNode (
                        2,
                        new TreeNode(3),
                        new TreeNode()
                )
        )));
    }
}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(){}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
