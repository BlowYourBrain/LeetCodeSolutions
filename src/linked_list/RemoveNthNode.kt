package linked_list

import company_interview_questions.add_two_numbers.ListNode

class RemoveNthNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var cur = head
        var length = 0

        while (cur != null){
            cur = cur?.next
            length++
        }

        if (n == length){
            return head?.next
        }

        var prevHead: ListNode? = null
        cur = head

        val deletionNodePosition = length - n
        var position = 0

        while(position < deletionNodePosition){
            position++
            prevHead = cur
            cur = cur?.next
        }

        prevHead?.next = cur?.next

        return head
    }
}