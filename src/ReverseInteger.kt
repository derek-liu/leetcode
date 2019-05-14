class ReverseInteger {
    fun reverse(x: Int): Int {
        val max = Int.MAX_VALUE
        val min = Int.MIN_VALUE
        val sign = if (x < 0) -1 else 1
        var result: Long = 0 // 重点要使用Long存储Int避免转化过程中发生溢出
        var temp: Int = Math.abs(x)
        while (temp != 0) {
            result = result * 10 + temp.rem(10)
            temp /= 10
        }
        return if (outBound(sign * result)) 0 else sign * result.toInt()
    }

    private fun outBound(x: Long): Boolean {
        return x < Int.MIN_VALUE || x > Int.MAX_VALUE
    }
}