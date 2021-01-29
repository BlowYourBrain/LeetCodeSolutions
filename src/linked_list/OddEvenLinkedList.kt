package linked_list

import company_interview_questions.add_two_numbers.ListNode

fun main(){
    val node6 = ListNode(6)
    val node5 = ListNode(5)
    val node4 = ListNode(4)
    val node3 = ListNode(3)
    val node2 = ListNode(2)
    val node1 = ListNode(1)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    val testList = node1

    OddEvenLinkedList()
        .oddEvenList(testList)
        .let {
            println("result:")
            printList(it)
        }
}

private fun printList(head: ListNode?) {
    var cur = head
    while (cur != null) {
        print("${cur.`val`} ")
        cur = cur.next
    }
    println()
}

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        val oddHead = head
        val evenHead = head?.next
        var curOdd = oddHead
        var curEven = evenHead

        while(curEven != null){
            val nextOdd = curOdd?.next?.next
            if (nextOdd != null){
                curOdd?.next = nextOdd
                curOdd = nextOdd
            }

            val nextEven = curEven?.next?.next
            curEven?.next = nextEven
            curEven = nextEven
        }

        curOdd?.next = evenHead

        return oddHead
    }
}