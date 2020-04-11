object DPAlgorithm {
    /**
     * 给定 1，5，11面值
     */
    private var capacity = listOf(1, 5, 11)

    fun leastAmountForSomeMoney(n: Int) {
        val f = mutableMapOf<Int, Int>()
        f[0] = 0
        for (i in 1..n) {
            var res = Int.MAX_VALUE
            capacity.forEach {
                if (i >= it) {
                    res = Math.min(res, f[i - it]!! + 1)
                }
            }
            f[i] = res
            println("f($i) = $res")
        }
    }


    /**
     * 最长上升子序列问题
     * f（i）代表以i位置上（0开始）的值为结尾的最长子串
     */

    val array = listOf(2, 3, 7, 1)

    fun longestAscentarray() {
        val f = mutableMapOf<Int, Int>()
        f[0] = 1
        for (i in 1 until array.size) {
            val value = array[i]
            for (j in 0..i) {
                if (array[j] < value) {
                    f[i] = Math.max((f[i] ?: 0), (f[j] ?: 0) + 1)
                } else {
                    f[i] = Math.max(f[i] ?: 0, f[j] ?: 0)
                }
            }
            println("f($i) = ${f[i]}")
        }
        println("max ${f.maxBy { it.value }}")
    }


    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var maxLength = 0
        var startIndex = 0
        var endIndex = 0
        val f = Array(s.length) { BooleanArray(s.length) }
        for (j in 0 until s.length) {
            f[j][j] = true
            for (i in 0 until j) {
                f[i][j] = (s[i] == s[j] && j - i < 2) || (s[i] == s[j] && f[i + 1][j - 1] && j > 0)
                if (f[i][j] && maxLength < (j - i + 1)) {
                    maxLength = j - i + 1
                    startIndex = i
                    endIndex = j
                }
            }
        }
        return s.substring(startIndex, endIndex + 1)
    }

    fun test windGit() {
        for (j in 0 until s.length) {
            f[j][j] = true
            for (i in 0 until j) {
                f[i][j] = (s[i] == s[j] && j - i < 2) || (s[i] == s[j] && f[i + 1][j - 1] && j > 0)
                if (f[i][j] && maxLength < (j - i + 1)) {
                    maxLength = j - i + 1
                    startIndex = i
                    endIndex = j
                }
            }
        }
    }

}