package company_interview_questions.add_two_numbers

//https://leetcode.com/problems/add-two-numbers/

fun main(args: Array<String>) {

    val l1 = createListNodeFromString(442.toString())
    val l2 = createListNodeFromString(665.toString())
    printListNode(l1)
    printListNode(l2)


    Solution().addTwoNumbers(l1, l2)
        ?.let { printListNode(it) }
}

fun createListNodeFromString(source: String): ListNode {
    var tail: ListNode? = null

    source.forEach {
        val temp = ListNode(it.toString().toInt(10))

        if (tail == null) {
            tail = temp
        } else {
            temp.next = tail
            tail = temp
        }
    }

    return tail!!
}

fun printListNode(listNode: ListNode) {
    var head = listNode
    print("(")
    while (true) {
        print(head.`val`)
        val nextNode = head.next
        if (nextNode == null) {
            println(")")
            break
        } else {
            print(" -> ")
            head = nextNode
        }
    }
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val compareableL1: ListNode = l1 ?: createEmptyNode()
        val compareableL2: ListNode = l2 ?: createEmptyNode()

        var headL1: ListNode? = compareableL1
        var headL2: ListNode? = compareableL2
        val tempResultList = mutableListOf<ListNode>()

        var index = 0
        var previousHead: ListNode? = null
        while (true) {
            val resultListNode = headL1.add(headL2)
            tempResultList.add(index++, resultListNode)

            previousHead?.next = resultListNode
            previousHead = resultListNode

            val nextNodeL1 = headL1?.next
            val nextNodeL2 = headL2?.next

            if (nextNodeL1 == null && nextNodeL2 == null) {
                break
            } else {
                headL1 = nextNodeL1
                headL2 = nextNodeL2
            }
        }

        for (downIndex in tempResultList.lastIndex downTo 0) {
            tempResultList[downIndex].calculate()
        }
        return tempResultList.first()
    }

    private fun ListNode.calculate() {
        var currentNode = this
        while (true) {
            if (currentNode.`val` > 9) {
                val nextNode = currentNode.next ?: createEmptyNode().also { currentNode.next = it }
                val nextNodeValue = nextNode.`val` + 1
                nextNode.`val` = nextNodeValue
                currentNode.`val` = currentNode.`val` - 10

                if (nextNodeValue > 9) {
                    currentNode = nextNode
                } else {
                    break
                }
            } else {
                break
            }
        }
    }

    private fun createEmptyNode(): ListNode {
        return ListNode(0)
    }

    private fun ListNode?.add(listNode: ListNode?): ListNode {
        return when {
            this != null && listNode != null -> {
                `val` += listNode.`val`
                this
            }
            this == null && listNode == null -> {
                createEmptyNode()
            }

            this == null -> {
                listNode!!
            }

            listNode == null -> {
                this
            }

            else -> {
                createEmptyNode()
            }
        }
    }
}