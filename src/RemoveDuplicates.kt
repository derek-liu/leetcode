object RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        var left = 0
        var right = 1
        while (right < nums.size) {
            if (nums[left] != nums[right]) {
                left++
                nums[left] = nums[right]
            }
            right++
        }
        return left + 1
    }
}