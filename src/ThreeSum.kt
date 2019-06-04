/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 */
object ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        nums.sort()
        var i = 1
        while (i < nums.size - 1) {
            var start = 0
            var end = nums.size - 1
            while (i in (start + 1)..(end - 1)) {
                when {
                    nums[start] + nums[end] > 0 - nums[i] -> end--
                    nums[start] + nums[end] < 0 - nums[i] -> start++
                    else -> {
                        list.add(listOf(nums[start], nums[i], nums[end]))
                        while (start < i - 1 && nums[start] == nums[start + 1]) {
                            start++
                        }
                        while (i + 1 < end && nums[end] == nums[end - 1]) {
                            end--
                        }
                        start++
                        end--
                    }
                }
            }

            while (i < nums.size - 1 && nums[i] == nums[i + 1]) {
                i++
            }
            i++
        }
        return list
    }
}