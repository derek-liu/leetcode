import java.util.*

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


    fun permute_2(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrace_2(nums, mutableListOf(), mutableMapOf(), result)
        return result
    }

    private fun backtrace_2(
        nums: IntArray,
        tmp: MutableList<Int>,
        used: MutableMap<Int, Boolean>,
        result: MutableList<List<Int>>
    ) {
        if (nums.size == tmp.size) {
            result.add(tmp.toList())
            return
        }
        for (i in 0 until nums.size) {
            if (used[i] != true) {
                used[i] = true
                tmp.add(nums[i])
                backtrace_2(nums, tmp, used, result)
                tmp.removeAt(tmp.size - 1)
                used[i] = false
            }
        }
    }

}