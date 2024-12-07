package problems.majorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class MajorityElement {
    public static void main(String[] args) {
        //input
        int[] nums = {3, 2, 3};

        Map<Integer, Integer> map = new HashMap<>();
        final int isMajorityCount = nums.length / 2;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > isMajorityCount) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println(0);
    }
}
