package src;

import java.util.Arrays;
import java.util.HashMap;

public class ContinuousSubArraySum {
  public static void main(String[] args) {
    int[] nums = {23, 2, 4, 6, 7};
    System.out.println(Arrays.toString(nums));
    int sum = 6;
    ContinuousSubArraySum solution = new ContinuousSubArraySum();
    boolean isPresent = solution.subArraySum(nums, sum);
    System.out.println(isPresent);
  }

  private void findSubArraySum(int[] nums, int sum) {
    if (nums == null) {
      return;
    }
    int startIndex = 0;
    int runningSum = nums[0];
    for (int endIndex = 1; endIndex < nums.length; endIndex++) {
      runningSum = runningSum + nums[endIndex];
      if (runningSum > sum) {
        runningSum = runningSum - nums[startIndex];
        startIndex++;
      }
      if (runningSum == sum) {
        for (int i = startIndex; i <= endIndex; i++) {
          System.out.println(nums[i]);
        }
      }
    }
  }
 /** Handle negative numbers */
  private boolean subArraySum(int[] nums, int sum) {
    if (nums == null) {
      return false;
    }
    int runningSum = 0;
    HashMap<Integer, Integer> hashMap = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      runningSum = runningSum + nums[i];
      if (runningSum == sum) {
        return true;
      }
      if (hashMap.containsKey(runningSum - sum)) {
        return true;
      }
      hashMap.put(runningSum, i);
    }
    return false;
  }
}
