class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1

        var p1 = l1
        var p2 = l2

        var carry: Int = 0
        var result: ListNode? = null
        var temp: ListNode? = null

        while (p1 != null && p2 != null) {
            val newNode = ListNode((p1.`val` + p2.`val` + carry) % 10)
            carry = (p1.`val` + p2.`val` + carry) / 10
            if (temp == null) {
                temp = newNode
                result = temp
            } else {
                temp.next = newNode
                temp = temp.next
            }
            p1 = p1.next
            p2 = p2.next
        }
        if (p1 == null && p2 != null) {
            while (p2 != null) {
                val newNode = ListNode((p2.`val` + carry) % 10)
                carry = (p2.`val` + carry) / 10
                temp?.next = newNode
                temp = temp?.next
                p2 = p2.next
            }
        }

        if (p2 == null && p1 != null) {
            while (p1 != null) {
                val newNode = ListNode((p1.`val` + carry) % 10)
                carry = (p1.`val` + carry) / 10
                temp?.next = newNode
                temp = temp?.next
                p1 = p1.next
            }
        }

        if (carry > 0) {
            val newNode = ListNode(carry)
            temp?.next = newNode
            temp = temp?.next
        }

        return result
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}