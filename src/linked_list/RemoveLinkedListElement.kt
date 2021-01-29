package linked_list

import company_interview_questions.add_two_numbers.ListNode

fun main() {
    val node6 = ListNode(6)
    val node5 = ListNode(5)
    val node4 = ListNode(4)
    val node3 = ListNode(3)
    val node2 = ListNode(2)
    val node1 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val testList = node1

    RemoveLinkedListElement()
        .removeElements(testList, 6)
        .let {
            println("result:")
            printList(it)
        }
}

private fun printList(head: ListNode?) {
    var cur = head
    while (cur != null) {
        print("${cur.`val`} ")
        cur = cur.next
    }
    println()
}

class RemoveLinkedListElement {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummyHead = ListNode(0)
        dummyHead.next = head
        var cur: ListNode? = head
        var previousHead: ListNode = dummyHead

        while (cur != null) {
            if (cur.`val` == `val`) {
                previousHead.next = cur?.next
            } else {
                previousHead = cur
            }
            cur = cur.next
        }

        return dummyHead.next
    }
}