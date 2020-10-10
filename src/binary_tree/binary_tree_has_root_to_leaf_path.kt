package binary_tree

fun main() {
    val root = listToTreeNode(
        listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
    )

    HasRootToLeafPathSolution()
        .hasPathSum(root, 22)
        .printlnResult()
        .let { assert(it) }
}

class HasRootToLeafPathSolution {

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }

        return findLeaf(root, 0, sum)
    }

    private fun findLeaf(node: TreeNode, actualSum: Int, expextedSum: Int): Boolean {
        if (node.left == null && node.right == null) {
            return actualSum + node.`val` == expextedSum
        }

        node.left?.let {
            val result = findLeaf(it, actualSum + node.`val`, expextedSum)
            if (result) {
                return result
            }
        }
        node.right?.let {
            val result = findLeaf(it, actualSum + node.`val`, expextedSum)
            if (result) {
                return result
            }
        }

        return false
    }

}