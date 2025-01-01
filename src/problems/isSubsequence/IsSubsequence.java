package problems.isSubsequence;

import org.w3c.dom.ls.LSOutput;

/**
 * 392. Is Subsequence
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining
 * characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 * <p>
 * <p>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your
 * code?
 */
public class IsSubsequence {
    public static void main(String[] args) {
        //        Input: s = "abc", t = "ahbgdc"
        //        Output: true
        final String s = "acb";
        final String t = "ahbgdc"; //false
        String duplicatedT = String.valueOf(t);
        for (int i = 0; i < s.length(); i++) {
            final char target = s.charAt(i);
            if (!duplicatedT.contains(String.valueOf(target))) {
                System.out.println(false);
                return;
            }
            final int targetIndex = duplicatedT.indexOf(String.valueOf(target));
            duplicatedT = duplicatedT.substring(targetIndex);
            duplicatedT = duplicatedT.replaceFirst(String.valueOf(target), "");
        }
        System.out.println(true);
        return;
    }
}
