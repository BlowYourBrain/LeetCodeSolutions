package binary_tree

import java.util.*

fun main() {
    val root = listToTreeNode(
        listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
    )

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun listToTreeNode(list: List<Int?>): TreeNode {
    val root = TreeNode(list.first()!!)
    var lvl: Queue<TreeNode> = LinkedList<TreeNode>()

    var currentNode = root

    var isLeftNodeProcessed = false
    var isRightNodeProcessed = false
    var index = 1

    while (true) {
        if (isLeftNodeProcessed && isRightNodeProcessed) {
            currentNode = lvl.poll()
            isLeftNodeProcessed = false
            isRightNodeProcessed = false
        }

        val item = list[index]

        val newNode: TreeNode? =
            if (item != null) {
                val node = TreeNode(item)
                lvl.add(node)
                node
            } else {
                null
            }

        when {
            !isLeftNodeProcessed -> {
                currentNode.left = newNode
                isLeftNodeProcessed = true
            }

            !isRightNodeProcessed -> {
                currentNode.right = newNode
                isRightNodeProcessed = true
            }
        }

        if (list.lastIndex > index) {
            index++
        } else {
            break
        }
    }

    return root
}

fun <T> T.printlnResult(text: String? = null): T {
    if (text == null) {
        println("result is: ${this.toString()}")
    } else {
        println("$text ${this.toString()}")
    }
    return this
}

//region Not working.
fun TreeNode.printTree() {
    val maxDepth = MaxDepthSolution().maxDepth(this)
    var maxNumber = 40
    var maxNumberSymbolsCount = 1

    while (maxNumber >= 10) {
        maxNumber /= 10
        maxNumberSymbolsCount++
    }

    val lineDividersCount = (maxNumberSymbolsCount + 1) / 2
    val builder = StringBuilder()
    printPosition(maxDepth, lineDividersCount)
}

private fun printPosition(depth: Int, lineDividersCount: Int): Int {
    val dividers = lineDividersCount * (depth - 1)
    val printPosition = depth * 2 + dividers
    return printPosition
}
//endregion