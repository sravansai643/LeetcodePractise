package com.LeetcodePractise.leetcodepart1;

public class RegularExpressionMatching {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) return s.isEmpty();

            boolean firstMatch = (!s.isEmpty() &&
                    (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

            if (p.length() >= 2 && p.charAt(1) == '*') {
                return (isMatch(s, p.substring(2)) ||
                        (firstMatch && isMatch(s.substring(1), p)));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }

        public static void main(String[] args) {
            RegularExpressionMatching solution = new RegularExpressionMatching();
            System.out.println(solution.isMatch("aa", "a")); // Output: false
            System.out.println(solution.isMatch("aa", "a*")); // Output: true
            System.out.println(solution.isMatch("ab", ".*")); // Output: true
        }
    }

