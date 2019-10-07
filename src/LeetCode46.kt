object LeetCode46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrace(nums, result, 0)
        return result
    }

    private fun backtrace(nums: IntArray, result: MutableList<List<Int>>, startIndex: Int) {
        if (startIndex == nums.size) {
            result.add(nums.toList())
            return
        }
        for (i in startIndex until nums.size) {
            swap(nums, startIndex, i)
            backtrace(nums, result, startIndex + 1)
            swap(nums, startIndex, i)
        }
    }

    private fun swap(nums: IntArray, from: Int, to: Int) {
        val temp = nums[from]
        nums[from] = nums[to]
        nums[to] = temp
    }

}