package linked_list

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

class FlattenAMultilevelDoublyLinkedList {

    fun flatten(root: Node?): Node? {
        if (root != null) {
            startNode(root)
        }

        return root
    }


    fun startNode(head: Node): Node {
        var cur: Node? = head
        var lastNode: Node = head

        while (cur != null) {
            val child = cur.child

            if (child != null) {
                val tempNext = cur.next
                val lastNode = startNode(child)

                cur?.next = child
                child?.prev = cur
                cur?.child = null
                lastNode?.next = tempNext
                tempNext?.prev = lastNode

                cur = tempNext ?: lastNode
            }

            lastNode = cur
            cur = cur?.next
        }

        return lastNode
    }

}