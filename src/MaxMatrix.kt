object MaxMatrix {
    fun getMaxMatrix(matrix: Array<IntArray>): IntArray {
        var finalMaxResult = Int.MIN_VALUE
        val finalArrayResult = IntArray(4)
        for (i in 0..(matrix.size - 1)) {
            for (j in i..(matrix.size - 1)) {
                val sum = IntArray(matrix[0].size)
                var start = 0
                var curStart = 0
                var end = 0
                for (k in 0..(matrix[0].size - 1)) {
                    for (p in i..j) {
                        sum[k] += matrix[p][k]
                    }
                }
                var cur = sum[0]
                var maxValue = sum[0]

                for (p in 1..(matrix[0].size - 1)) {
                    if (cur <= 0) {
                        curStart = p
                        cur = sum[p]
                    } else {
                        cur += sum[p]
                    }
                    if (cur > maxValue) {
                        maxValue = cur
                        start = curStart
                        end = p
                    }
                }
               if (maxValue > finalMaxResult) {
                   finalMaxResult = maxValue
                   finalArrayResult[0] = i
                   finalArrayResult[1]= start
                   finalArrayResult[2] = j
                   finalArrayResult[3] = end
               }

            }
        }
        return finalArrayResult
    }
}