package linked_list

import company_interview_questions.add_two_numbers.ListNode

class IntersectionOfTwoLists {

    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val nodesSet = HashSet<ListNode>()
        var curA = headA
        var curB = headB
        while(curA != null || curB != null){
            if (curA != null){
                if (nodesSet.contains(curA)){
                    return curA
                }

                nodesSet.add(curA)
            }

            if(curB != null){
                if (curB != null && nodesSet.contains(curB)){
                    return curB
                }

                nodesSet.add(curB)
            }


            curA = curA?.next
            curB = curB?.next
        }

        return null
    }

}