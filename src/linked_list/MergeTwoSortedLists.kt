package linked_list

import company_interview_questions.add_two_numbers.ListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {

        var head: ListNode? = ListNode(0)
        var resultHead = head
        var headL1 = l1
        var headL2 = l2

        while (headL1 != null && headL2 != null) {

            if (headL1.`val` > headL2.`val`) {
                head?.next = headL2
                headL2 = headL2.next
            } else {
                head?.next = headL1
                headL1 = headL1.next
            }

            head = head?.next
        }

        if (headL1 != null) {
            head?.next = headL1
        }

        if (headL2 != null) {
            head?.next = headL2
        }

        return resultHead?.next
    }
}