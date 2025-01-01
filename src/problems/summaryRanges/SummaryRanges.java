package problems.summaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * <p>
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that
 * x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 * <p>
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All the values of nums are unique.
 * nums is sorted in ascending order.
 */
public class SummaryRanges {
    public static void main(String[] args) {
        final int[] nums = {0, 2, 3, 4, 6, 8, 9};
        final List<String> answer = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (start == i) {
                    answer.add(String.format("%d", nums[start]));
                } else {
                    answer.add(String.format("%d->%d", nums[start], nums[i]));
                }
                break;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                continue;
            }
            if (start == i) {
                answer.add(String.format("%d", nums[start]));
            } else {
                answer.add(String.format("%d->%d", nums[start], nums[i]));
            }
            start = i + 1;
        }
        System.out.println(answer.toString());
    }
}
