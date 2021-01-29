package linked_list

import company_interview_questions.add_two_numbers.ListNode
import java.lang.Math.abs

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

class IntersectionOfTwoLists2 {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var curA = headA
        var curB = headB
        var curALength = 0
        var curBLength = 0
        while(curA != null || curB != null){
            if (curA != null){
                curALength++
                curA = curA?.next
            }

            if (curB != null){
                curBLength++
                curB = curB?.next
            }
        }
        val lengthDiff = curALength - curBLength

        var (head1, head2) = if (lengthDiff !=0){
            var (cur, otherCur) = if (lengthDiff >0){
                headA to headB
            }else{
                headB to headA
            }

            val diff = kotlin.math.abs(lengthDiff)
            var count = 0
            while(count < diff){
                cur = cur?.next
                count++
            }
            cur to otherCur
        } else {
            headA to headB
        }

        while(head1 != null && head2 != null){
            if (head1 == head2){
                return head1
            }
            head1 = head1.next
            head2 = head2.next
        }

        return null
    }
}