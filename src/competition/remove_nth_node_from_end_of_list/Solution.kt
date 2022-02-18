package competition.remove_nth_node_from_end_of_list

import company_interview_questions.add_two_numbers.ListNode
import company_interview_questions.add_two_numbers.createListNodeFromString
import kotlin.test.assertEquals
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
fun main() {
    Solution().apply {
        testCase1()
        testCase2()
    }
}

private fun Solution.testCase1() {
    val expected = createListNodeFromString("2")
    val node = createListNodeFromString("12")

    commonTestCase(
        input = node to 2,
        expected = expected
    )
}

private fun Solution.testCase2() {
    val expected = createListNodeFromString("1")
    val node = createListNodeFromString("12")

    commonTestCase(
        input = node to 1,
        expected = expected
    )
}

private fun Solution.commonTestCase(
    input: Pair<ListNode?, Int>,
    expected: ListNode?
) {
    assertEquals(
        expected,
        removeNthFromEnd(input.first, input.second)
    )
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val tempHead = ListNode(0)

        tempHead.next = head
        var fastPointer: ListNode? = tempHead
        var slowPointer: ListNode? = tempHead

        for (i in 0 until n){
            fastPointer = fastPointer?.next
        }


        while (fastPointer?.next != null) {
            fastPointer = fastPointer?.next
            slowPointer = slowPointer?.next
        }
        slowPointer?.next = slowPointer?.next?.next
        return tempHead.next
    }
}
