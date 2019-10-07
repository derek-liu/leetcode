object Leetcode61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) return head
        var temp = head
        var size = 1
        while (temp?.next != null) {
            temp = temp.next
            size++
        }
        temp?.next = head
        val forwardPosition = size - k.rem(size)
        var resuleHeader = head
        for (i in 0 until forwardPosition) {
            resuleHeader = resuleHeader?.next
            temp = temp?.next
        }
        temp?.next = null
        return resuleHeader
    }
}