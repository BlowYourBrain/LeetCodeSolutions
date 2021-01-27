package linked_list

import company_interview_questions.add_two_numbers.ListNode

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var cur = head
        var oneStepFurther = head

        while(cur?.next != null){
            cur = cur?.next
            oneStepFurther = oneStepFurther?.next?.next
            if (cur == oneStepFurther){
                return true
            }
        }

        return false
    }
}