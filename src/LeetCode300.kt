import java.util.Arrays

object LeetCode300 {

    //更简洁写法
    fun lengthOfLIS_Simple(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        Arrays.fill(dp, 1)
        var res = 1
        for (index in 0..(nums.size - 1)) {
            for (curIndex in 0..(index - 1)) {
                if (nums[curIndex] < nums[index]) {
                    dp[index] = Math.max(dp[index], dp[curIndex] + 1)
                }
            }
            res = Math.max(res, dp[index])
        }
        return res
    }


    fun lengthOfLIS(nums: IntArray): Int {
        var result = 1
        val array = arrayOfNulls<Int>(nums.size)
        val counts = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            result = Math.max(result, longestOfIth(nums, counts, index, array))
        }
        return result
    }

    /**
     * 到i位置的最长递增子序列的长度
     */
    fun longestOfIth(array: IntArray, counts: IntArray, i: Int, dp: Array<Int?>): Int {
        var result = 1
        if (i !in array.indices) return result
        if (dp[i] != null) {
            return dp[i]!!
        }
        for (index in 0 until i) {
            if (array[i] > array[index]) {
//                result = Math.max(result, longestOfIth(array, counts, index, dp) + 1)
                val length = longestOfIth(array, counts, index, dp)
                if (result < length + 1) {
                    result = length + 1
                    counts[i] = counts[index]
                } else if (result == length + 1) {
                    counts[i] += counts[index]
                }
            }
        }
        dp[i] = result
        return result
    }

    fun findNumberOfLIS(nums: IntArray): Int {
        var longestLength = 1
        val array = arrayOfNulls<Int>(nums.size)
        val counts = IntArray(nums.size, { 1 })
        nums.forEachIndexed { index, i ->
            longestLength = Math.max(longestLength, longestOfIth(nums, counts, index, array))
        }
        var res = 0
        array.forEachIndexed { index, i ->
            if (longestLength == i) {
                res += counts[index]
            }
        }
        return res
    }

    /**
     * dp就只存储当前的i的值
     * 以i位置元素结尾的子串，一定是以i位置元素为结尾的最长子串长度+1
     */

}