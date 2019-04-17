class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            val another = target - value
            if (map.containsKey(another)) {
                return IntArray(2).apply {
                    set(0, map[another]!!)
                    set(1, index)
                }
            }
            map[value] = index
        }
        throw IllegalStateException("Not Found")
    }
}