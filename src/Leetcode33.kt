object Leetcode33 {
    fun search(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (nums[mid] == target) {
                return mid
            }
            if (nums[low] <= nums[mid] && nums[low] <= target && target <= nums[mid]) {
                high = mid
            } else if (nums[low] > nums[mid] && target <= nums[mid]) {
                high = mid
            } else if (nums[low] > nums[mid] && target >= nums[low]) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return -1
    }
}