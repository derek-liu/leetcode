/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */

object SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = if (nums.isEmpty()) -1 else searchLower(nums, target)
        val right = if (nums.isEmpty()) -1 else searchUpper(nums, target)
        return intArrayOf(left, right)
    }

    fun searchLower(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (target > nums[mid]) {
                left = mid + 1
            } else if (target < nums[mid]) {
                right = mid - 1
            } else if (mid > left && nums[mid - 1] == target) {
                right = mid - 1
            } else {
                return mid
            }

        }
        return -1
    }

    fun searchUpper(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (target > nums[mid]) {
                left = mid + 1
            } else if (target < nums[mid]) {
                right = mid - 1
            } else if (mid < right && nums[mid + 1] == target) {
                left = mid + 1
            } else {
                return mid
            }

        }
        return -1
    }
}