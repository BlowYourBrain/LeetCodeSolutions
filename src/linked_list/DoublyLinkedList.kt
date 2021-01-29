package linked_list


fun main() {
    val head = DoublyLinkedList().apply {
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

class DoublyLinkedList {

    /** Initialize your data structure here. */
    class Node(val `val`: Int, var prev: Node? = null, var next: Node? = null)

    var head: Node? = null

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        var position = 0
        var cur = head

        while (position < index && cur != null) {
            position++
            cur = cur.next
        }

        return cur?.`val` ?: -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        val newHead = Node(`val`)

        if (head == null) {
            head = newHead
        } else {
            newHead?.next = head
            head?.prev = newHead
            head = newHead
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        var tail = head
        while (tail?.next != null) {
            tail = tail.next
        }
        val newTail = Node(`val`)

        if (tail == null) {
            head = newTail
        } else {
            tail?.next = newTail
            newTail?.prev = tail
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        var position = 0
        var cur = head
        var prevNode = cur?.prev
        while (position < index && cur != null) {
            prevNode = cur
            cur = cur.next
            position++
        }

        if (position != index) {
            return
        }

        if (position == 0) {
            addAtHead(`val`)
        } else {
            val newNode = Node(`val`)

            if (cur == null){
                prevNode?.next = newNode
                newNode.prev = prevNode
            }else{
                prevNode?.next = newNode
                cur?.prev = newNode
                newNode?.next = cur
                newNode?.prev = prevNode
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        var position = 0
        var cur = head

        if (index == 0){
            head = head?.next
            head?.prev = null
        }

        while (position < index && cur != null) {
            cur = cur.next
            position++
        }

        if (position != index) {
            return
        }

        val prevNode = cur?.prev
        val nextNode = cur?.next
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }

}