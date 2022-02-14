package Blind75.Array

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

object ContainsDuplicate {

  def containsDuplicateSet(nums: Array[Int]): Boolean = {
    nums.toSet.size != nums.length
  }

  def containsDuplicateSorting(nums: Array[Int]): Boolean = {
    val sortedNums = quickSort(nums)
    for (i <- 0 until sortedNums.length - 1) {
      if (sortedNums(i) == sortedNums(i+1)) return true
    }
    false
  }

  import scala.collection.mutable.HashSet
  def containsDuplicateHashMap(nums: Array[Int]): Boolean = {
    val set = new HashSet[Int]()
    for (num <- nums) {
      if (set.contains(num)) return true
      set.add(num)
    }
    false
  }

  def quickSort(nums: Array[Int]): Array[Int] = {
    if (nums.length <= 1) nums
    else {
      val pivot = nums(nums.length/2)
      quickSort(nums.filter(pivot > _)).concat(nums.filter(pivot == _)).concat(quickSort(nums.filter(pivot < _)))
    }
  }

}
