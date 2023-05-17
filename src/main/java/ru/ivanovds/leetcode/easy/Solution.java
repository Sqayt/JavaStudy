package ru.ivanovds.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        if (n + m - tmp >= 0) System.arraycopy(nums2, tmp - tmp, result, tmp, n + m - tmp);
        
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

    public int[] decompressRLElist(int[] nums) {
        int[] result = new int[]{};
        int freq = 0;
        int val = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                freq = nums[i];
            } else {
                val = nums[i];
            }
            if (i % 2 != 0) {
                int[] newArray = generate(freq, val);
                result = concatArray(result, newArray);
            }
        }

        return result;
    }

    public int[] generate(int freq, int val) {
        int[] array = new int[freq];
        Arrays.fill(array, val);

        return array;
    }

    public int[] concatArray(int[] array, int[] array2) {
        return IntStream.concat(Arrays.stream(array), Arrays.stream(array2)).toArray();
    }

    public int[] decode(int[] array, int first) {
        int size = array.length;
        int[] res = new int[size + 1];
        res[0] = first;
        for (int i = 0; i < size; ++i) {
            res[i + 1] = res[i] ^ array[i];
        }

        return res;
    }

    int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);

        return ans;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                ans += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }

    public int balancedStringSplit(String s) {
        String[] words = s.split("");
        int ans = 0;
        int result = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("R"))
                ans++;
            else if (words[i].equals("L"))
                ans--;
            if (ans == 0)
                result++;
        }

        return result;
    }

    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) res += i;
            else if (i % 5 == 0) res += i;
            else if (i % 7 == 0) res += i;
        }
        return res;
    }

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }

        return res;
    }

    public List<String> cellsInRange(String s) {
        String[] coord = s.split(":");
        String[] first = coord[0].split("");
        String[] last = coord[1].split("");

        String firstElement = first[0];
        int firstNumber = Integer.parseInt(first[1]);
        String lastElement = last[0];
        int lastNumber = Integer.parseInt(last[1]);

        List<String> result = new ArrayList<>();
        for (int i = firstElement.charAt(0); i <= lastElement.charAt(0); i++) {
            for (int j = firstNumber; j <= lastNumber; j++) {
                result.add(Character.toString(i).concat(String.valueOf(j)));
            }
        }

        return result;
    }

    public String decodeMessage(String key, String message) {
        String[] keys = key.replaceAll(" ", "").split("");
        String keyIndex = new LinkedHashSet<>(Arrays.asList(keys)).toString()
                .replaceAll("(^\\[|\\]$)", "")
                .replace(", " ,"");

        String[] messageIndex = message.split("");
        List<Integer> indexAll = new ArrayList<>();

        for (String index : messageIndex) {
            if (index.equals(" ")) {
                indexAll.add(32);
                continue;
            }
            indexAll.add(keyIndex.indexOf(index) + 97);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageIndex.length; i++) {
            sb.append((char) (int) indexAll.get(i));
        }

        return sb.toString();
    }

//    public boolean canConstruct(String ransomNote, String magazine) {
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//
//            int matchingIndex = magazine.indexOf(c);
//
//            if (matchingIndex == -1) {
//                return false;
//            }
//
//            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
//        }
//
//        return true;
//    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineLetters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char m = magazine.charAt(i);

            int currentCount = magazineLetters.getOrDefault(m, 0);
            magazineLetters.put(m, currentCount + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = magazine.charAt(i);

            int currentCount = magazineLetters.getOrDefault(r, 0);
            if (currentCount == 0) {
                return false;
            }

            magazineLetters.put(r, currentCount - 1);
        }
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aab", "baa"));
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