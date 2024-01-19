package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("started.");
        return;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node dst = new Node();
        cloneNode(node, dst, nodeMap);
        return dst;
    }

    public void cloneNode(Node src, Node dst, Map<Integer, Node> nodeMap) {
        dst.val = src.val;
        if (!nodeMap.containsKey(src.val)) {
            nodeMap.put(src.val, dst);
        }
        for (int i = 0; i < src.neighbors.size(); i++) {
            Node neighborDst = new Node();
            Node neighborSrc = src.neighbors.get(i);
            if (nodeMap.containsKey(neighborSrc.val)) {
                neighborDst = nodeMap.get(neighborSrc.val);
            } else {
                nodeMap.put(neighborSrc.val, neighborDst);
                cloneNode(neighborSrc, neighborDst, nodeMap);
            }
            dst.neighbors.add(neighborDst);
        }
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int lengthDiff = word2.length() - word1.length();
        if (lengthDiff >= 0) {
            for (int i = 0; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            for (int i = word1.length(); i < word2.length(); i++) {
                sb.append(word2.charAt(i));
            }
        } else {
            for (int i = 0; i < word2.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            for (int i = word2.length(); i < word1.length(); i++) {
                sb.append(word1.charAt(i));
            }
        }
        return sb.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());
        if (gcd == 0) {
            return "";
        }
        String gcdStr = str1.substring(0, gcd);
        if (!checkGcdStr(str1, gcdStr)) {
            return "";
        }
        if (!checkGcdStr(str2, gcdStr)) {
            return "";
        }
        return gcdStr;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean checkGcdStr(String str, String gcdStr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / gcdStr.length(); i++) {
            sb.append(gcdStr);
        }
        return str.equals(sb.toString());
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> results = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < candies.length; i++) {
            if (maxCount < candies[i]) {
                maxCount = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            results.add(maxCount <= candies[i] + extraCandies);
        }
        return results;
    }

    public String reverseVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('A');
        vowelsSet.add('e');
        vowelsSet.add('E');
        vowelsSet.add('i');
        vowelsSet.add('I');
        vowelsSet.add('o');
        vowelsSet.add('O');
        vowelsSet.add('u');
        vowelsSet.add('U');
        List<Character> result = new ArrayList<>();
        Stack<Character> vowels = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowelsSet.contains(c)) {
                vowels.push(c);
                result.add(null);
            } else {
                result.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            Character c = result.get(i);
            if (c == null) {
                sb.append(vowels.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        boolean willBeFromWord1 = true;
        int word1Index = 0;
        int word2Index = 0;
        boolean completed = false;
        if (word1Index < word1.length()) {
            willBeFromWord1 = true;
        } else {
            completed = true;
        }
        while (!completed) {
            char c;
            if (willBeFromWord1) {
                c = word1.charAt(word1Index);
                word1Index++;
            } else {
                c = word2.charAt(word2Index);
                word2Index++;
            }
            sb.append(c);
            // judge
            if (willBeFromWord1) {
                if (word2Index < word2.length()) {
                    willBeFromWord1 = false;
                } else if (word1Index < word1.length()) {
                    willBeFromWord1 = true;
                } else {
                    completed = true;
                }
            } else {
                if (word1Index < word1.length()) {
                    willBeFromWord1 = true;
                } else if (word2Index < word2.length()) {
                    willBeFromWord1 = false;
                } else {
                    completed = true;
                }
            }
        }
        return sb.toString();
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> charIndices = new HashMap<>();
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer n = charIndices.getOrDefault(c, null);
            if (n == null) {
                charIndices.put(c, i);
            } else {
                int length = i - n - 1;
                if (maxLength < length) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    public String reorganizeString(String s) {
        if (s.equals("")) {
            return "";
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        char[] result = new char[s.length()];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int j = 0; j < freqMap.get(c); j++) {
                if (i >= s.length())
                    i = 1;
                result[i] = c;
                i += 2;
            }
        }

        return new String(result);
    }

    public static void main1(String[] args) {
        Solution s = new Solution();
        int[][] input = {
                { 2, 8, 7 },
                { 7, 1, 3 },
                { 1, 9, 5 }
        };

        ListNode firstNode = new ListNode(1);
        ListNode current = firstNode;
        for (int i = 2; i < 6; i++) {
            ListNode nextNode = new ListNode(i);
            current.next = nextNode;
            current = current.next;
        }
        System.out.println(firstNode.toString());
    }

    /**
     * |c[0]|c[1]|c[2]|c[3]|
     * 0 1 2 3 4
     * | leftLimit
     * | rightLimit
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int leftLimit = 0;
        int rightLimit = 0;
        int maxLength = rightLimit - leftLimit;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            Integer sameCharIndex = chars.get(c);
            if (sameCharIndex != null) {
                chars.clear();
                leftLimit = sameCharIndex + 1;
                rightLimit = sameCharIndex + 1;
                i = sameCharIndex + 1;
            } else {
                chars.put(c, i);
                rightLimit = i + 1;
                i = i + 1;
                int length = rightLimit - leftLimit;
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }
}
