package src;

/**
 * Created by ssahoo on 12/17/18.
 */
public class FindSecondMax {
  public static void main(String[] args) {
    int nums[] = {12, 13, 1, 10, 34, 1, 34};
    FindSecondMax secondMax = new FindSecondMax();
    secondMax.findSecondMax(nums);

  }
  private int findSecondMax(int[] nums) {
    int firstMax = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > firstMax) {
        secondMax = firstMax;
        firstMax = nums[i];
      }
      else if (nums[i] < firstMax && nums[i] > secondMax) {
        secondMax = nums[i];
      }
    }
    System.out.println(secondMax);
    return secondMax;
  }
}
