package linked_list

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class CopyListWithRandomPointer {

    fun copyRandomList(node: Node?): Node? {
        val originalNodesHashMap = hashMapOf<Node, Int?>()
        val deepCopyNodesArray = mutableListOf<Node>()

        var cur = node
        var index = 0

        while (cur != null) {
            originalNodesHashMap.put(cur, index)
            cur = cur?.next
            index++
        }

        cur = node

        var copyNode: Node? = null
        var prevCopyNode: Node? = null
        var deepCopyHead: Node? = null

        while (cur != null) {
            copyNode = Node(cur.`val`)
            prevCopyNode?.next = copyNode
            prevCopyNode = copyNode

            cur = cur?.next

            if (deepCopyHead == null) {
                deepCopyHead = copyNode
            }


            deepCopyNodesArray.add(copyNode)
        }

        cur = node
        var copyNodeCur = deepCopyHead

        while (cur != null) {
            originalNodesHashMap.get(cur)?.let { randomNodeIndex ->
                val randomNode = deepCopyNodesArray[randomNodeIndex]
                copyNodeCur?.random = randomNode
            }

            cur = cur?.next
            copyNodeCur = copyNodeCur?.next
        }

        return deepCopyHead
    }

}