package problems.validPalindrome;

public class ValidPalindromeOptimized {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if(!Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
            }else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    System.out.println(false);
                    return;
                }
                left++;
                right--;
            }
        }
        System.out.println(true);
    }
}
