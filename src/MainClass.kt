fun main(args: Array<String>) {
    val input = intArrayOf(1)
    val header = convertToNodeList(input)
    val result = Leetcode61.rotateRight(header, 0)
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