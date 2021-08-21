import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val input = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    val time = measureTimeMillis {
        val result = LeetCode300.lengthOfLIS(input)
        println("result $result")
    }
    println("time $time")
}