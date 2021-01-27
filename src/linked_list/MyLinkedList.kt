package linked_list

fun main() {
    MyLinkedList().apply {
        addAtHead(7)
        addAtHead(2)
        addAtHead(1)
        addAtIndex(3, 0)
        deleteAtIndex(2)
        addAtHead(6)
        addAtTail(4)
        get(4)
        addAtHead(4)
        addAtIndex(5, 0)
        addAtHead(6)
    }
}

class MyLinkedList() {

    /** Initialize your data structure here. */
    private var head: Node? = null
    private var tail: Node? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        var listIndex = 0
        var iterationHead = head

        while (iterationHead != null && listIndex < index) {
            iterationHead = iterationHead.next
            listIndex++
        }

        return iterationHead?.`val` ?: -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        head = Node(`val`, head)

        if (tail == null) {
            tail = head
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        tail.let {
            if (it == null) {
                addAtHead(`val`)
            } else {
                it.next = Node(`val`)
                tail = it.next
            }
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        var listIndex = 0
        var iterationHead: Node? = head
        var iterationPreviousHead: Node? = null

        while (iterationHead != null && listIndex < index) {
            iterationPreviousHead = iterationHead
            iterationHead = iterationHead.next
            listIndex++
        }

        if (listIndex == index) {
            //when we add item at start
            if (iterationPreviousHead == null) {
                head = Node(`val`, head)
                tail = head
            } else {
                iterationPreviousHead.next = Node(`val`, iterationHead)
                //in case when delete last index
                if (iterationHead == null) {
                    tail = iterationPreviousHead.next
                }
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        var listIndex = 0
        var iterationHead = head
        var iterationPreviousHead = head

        if (index == 0) {
            head = head?.next
            //in case when there is only one element left and we already delete it
            if (head == null) {
                tail = null
            }
            return
        }

        while (iterationHead != null && listIndex < index) {
            iterationPreviousHead = iterationHead
            iterationHead = iterationHead.next
            listIndex++
        }

        if (listIndex == index) {
            iterationPreviousHead?.next = iterationHead?.next

            if (iterationPreviousHead?.next == null) {
                tail = iterationPreviousHead
            }
        }
    }

    internal class Node(val `val`: Int, var next: Node? = null)

}
