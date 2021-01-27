package company_interview_questions.merge_two_sorted_list

fun main(){

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

//    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
//        val result = if (l1?.`val` ?: 0 > l2?.`val` ?: 0) {
//            l1
//        } else {
//            l2
//        }
//
//        var l1Head = l1
//        var l2Head = l2
//
//        while (l1Head != null && l2Head != null) {
//            val (smallerHead, biggerHead) = if (l1Head.`val` < l2Head.`val`) {
//                l1Head to l2Head
//            } else {
//                l2Head to l1Head
//            }
//
//            var smallerTail = smallerHead.next
//            while(smallerTail)
//        }
//
//        return result
//    }
}