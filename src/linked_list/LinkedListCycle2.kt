package linked_list

import company_interview_questions.add_two_numbers.ListNode

class Solution2 {

    fun detectCycle(head: ListNode?): ListNode? {
        val hashSet = HashSet<ListNode>()
        var cur = head
        while (cur != null) {
            val hasCurrent = hashSet.contains(cur)
            if (hasCurrent) {
                return cur
            }
            hashSet.add(cur)
            cur = cur.next
        }

        return null
    }

}