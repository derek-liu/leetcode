object RemoveNthFromEnd {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var behind: ListNode? = null
        var ahead: ListNode? = head
        var length = if (head != null) 1 else 0
        while (ahead?.next != null) {
            ahead = ahead.next
            length++
            if (length > n) {
                behind = if (behind == null) head else behind.next
            }
        }

        return if (n <= 0 || n > length) {
            null
        } else if (n == length) {
            head?.next
        } else {
            val temp = behind?.next
            behind?.next = temp?.next
            temp?.next = null
            head
        }
    }
}