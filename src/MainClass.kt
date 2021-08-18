import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val input = intArrayOf(1,2,4,3,5,4,7,2)
    val time = measureTimeMillis {
        val result = LeetCode300.findNumberOfLIS(input)
        println("result $result")
    }
    println("time $time")
}