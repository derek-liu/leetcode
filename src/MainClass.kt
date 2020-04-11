fun main(args: Array<String>) {
    val input = intArrayOf(1, 2, 3)
    val target = 7
    val result = LeetCode46.permute_2(input)
    println("result $result")
}

private fun convertToNodeList(intArray: IntArray?): ListNode? {
    if (intArray?.isNotEmpty() != true) return null
    var header: ListNode? = null
    var temp: ListNode? = null
    intArray.forEachIndexed { index, i ->
        if (index == 0) {
            header = ListNode(i)
            temp = header
        } else {
            temp?.next = ListNode(i)
            temp = temp?.next
        }
    }
    return header

}