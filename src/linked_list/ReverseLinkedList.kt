package linked_list

import company_interview_questions.add_two_numbers.ListNode

class ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode? {
        var newHead: ListNode? = null
        var cur = head

        while (cur != null) {
            val temp = newHead
            newHead = cur
            cur = cur.next
            newHead?.next = temp
        }

        return newHead
    }

}