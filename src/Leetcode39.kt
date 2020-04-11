/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
[7],
[2,2,3]
]
 */
object Leetcode39 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        backtrace(candidates, target, result, mutableListOf<Int>(), 0)
        return result
    }


    private fun backtrace(
        candidates: IntArray,
        target: Int,
        result: MutableList<List<Int>>,
        tmp: MutableList<Int>,
        startIndex: Int
    ) {
        if (target < 0) return
        if (target == 0) {
            result.add(tmp.toList())
        }
        for (i in startIndex until candidates.size) {
            tmp.add(candidates[i])
            backtrace(candidates, target - candidates[i], result, tmp, i)
            tmp.removeAt(tmp.size - 1)
        }
    }
}