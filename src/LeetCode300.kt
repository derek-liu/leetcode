object LeetCode300 {
    fun lengthOfLIS(nums: IntArray): Int {
        var result = 1
        val array = arrayOfNulls<Int>(nums.size)
        nums.forEachIndexed { index, i ->
            result = Math.max(result, longestOfIth(nums, index, array))
        }
        return result
    }

    /**
     * 到i位置的最长递增子序列的长度
     */
    fun longestOfIth(array: IntArray, i: Int, dp: Array<Int?>): Int {
        var result = 1
        if (i !in array.indices) return result
        if (dp[i] != null) {
            return dp[i]!!
        }
        for (index in 0 until i) {
            if (array[i] > array[index]) {
                result = Math.max(result, longestOfIth(array, index, dp) + 1)
            }
        }
        dp[i] = result
        return result
    }

    /**
     * dp就只存储当前的i的值
     * 以i位置元素结尾的子串，一定是以i位置元素为结尾的最长子串长度+1
     */

}