object MaxSubArray {

    fun maxSubArray_Simple(nums: IntArray): Int {
        var res = nums[0]
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        for (index in 1..(nums.size -1)) {
            dp[index] = nums[index] + Math.max(0, dp[index - 1])
            res = Math.max(res, dp[index])
        }
        return res
    }

    fun maxSubArray(nums: IntArray): Int {
        var res = nums[0]
        val dp = arrayOfNulls<Int>(nums.size)
        for (i in nums.indices) {
            res = Math.max(res, maxSubArrayByIndex(nums, i, dp))
        }
        return res
    }

    private fun maxSubArrayByIndex(nums: IntArray, index: Int, dp: Array<Int?>): Int {
        if (index <= 0) {
            dp[0] = nums[0]
            return nums[0]
        }
        if (dp[index] != null) {
            return dp[index]!!
        }
        val res = nums[index] + Math.max(0, maxSubArrayByIndex(nums, index - 1, dp))
        dp[index] = res
        return res
    }
}