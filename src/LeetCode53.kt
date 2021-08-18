object LeetCode53 {
    fun maxSubArray(nums: IntArray): Int {
        var result = nums[0]
        val dp = arrayOfNulls<Int?>(nums.size)
        for (i in 0..(nums.size - 1)) {
            result = Math.max(result, maxSubArrayByIndex(nums, i, dp))
        }
        return result
    }

    private fun maxSubArrayByIndex(nums: IntArray, index: Int, dp: Array<Int?>): Int {
        if (index == 0) {
            return nums[0]
        }
        if (dp[index] != null) {
            return dp[index]!!
        }
        val result = nums[index] + Math.max(0, maxSubArrayByIndex(nums, index - 1, dp))
        dp[index] = result
        return result
    }
}