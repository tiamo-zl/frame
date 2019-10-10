package com.lll.sort.algorithm;

/**
 * @ClassName ArrayAlgorithm
 * @Description 数组相关算法
 * @Author zl
 * @Create 2019-04-01 11:06
 **/
public class ArrayAlgorithm {

  /**
   * 查询某个目标数在一个有序数组中应该寻在的位置
   * @param nums
   * @param target
   * @return
   */
  public static int searchInsert(int[] nums, int target) {
    int previousIndex = 0;
    int behindIndex = nums.length - 1;
    int middleIndex = (previousIndex + behindIndex)/2;

    while (true){
      if (previousIndex > behindIndex){
        return previousIndex;
      }
      if (target == nums[middleIndex]){
        return middleIndex;
      } else if (target > nums[middleIndex]){
        previousIndex = middleIndex + 1;
        middleIndex = (previousIndex + behindIndex)/2;
      } else {
        behindIndex = middleIndex - 1;
        middleIndex = (previousIndex + behindIndex)/2;
      }
    }

  }

}
