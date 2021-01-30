package linked_list

import company_interview_questions.add_two_numbers.ListNode

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (k == 0){
            return head
        }

        var length = 0
        var cur = head
        while(cur != null){
            cur = cur.next
            length++
        }

        if (length == 0){
            return head
        }

        val diff = k % length
        if (diff == 0){
            return head
        }

        cur = head
        var index = 0
        var lastIndex = length - 1 - diff
        while(index < lastIndex){
            cur = cur?.next
            index++
        }

        val newHead = cur?.next
        var curSegment = newHead
        cur?.next = null

        while(curSegment?.next != null){
            curSegment = curSegment.next
        }

        curSegment?.next = head

        return newHead
    }
}