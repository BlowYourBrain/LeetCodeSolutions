package linked_list

import company_interview_questions.add_two_numbers.ListNode

fun main() {
//    val node7 = ListNode(1)
//    val node6 = ListNode(2)
//    val node5 = ListNode(3)
//    val node4 = ListNode(4)
//    val node3 = ListNode(3)
    val node2 = ListNode(2)
    val node1 = ListNode(1)
    node1.next = node2
//    node2.next = node3
//    node3.next = node4
//    node4.next = node5
//    node5.next = node6
//    node6.next = node7

    val testList = node1

    PalindromeLinkedList()
        .isPalindrome(testList)
        .let {
            println("isPalindrome = $it")
        }
}

class PalindromeLinkedList {
    fun isPalindrome(head: ListNode?): Boolean {
        var length = 0
        var cur = head
        while (cur != null) {
            length++
            cur = cur.next
        }

        val halfPalindrome = length / 2
        var position = 0
        cur = head
        var previousHead: ListNode? = null

        while (position < halfPalindrome) {
            val tempCur = cur
            cur = cur?.next
            tempCur?.next = previousHead
            previousHead = tempCur
            position++
        }

        var pastHalfHead = if (length % 2 == 0) {
            cur
        } else {
            cur?.next
        }

        var reversedHead = previousHead

        while (pastHalfHead != null) {
            if (pastHalfHead.`val` != reversedHead?.`val`) {
                return false
            }

            pastHalfHead = pastHalfHead?.next
            reversedHead = reversedHead?.next
        }

        return true
    }
}