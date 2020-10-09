package binary_tree

class MaxDepthSolution {

    fun maxDepth(root: TreeNode?): Int {
        return root?.getLeft() ?: 0
    }

    fun TreeNode.getLeft(): Int {
        val leftDepth = left?.getLeft() ?: 0
        val rightDepth = right?.getRight() ?: 0
        return maxOf(leftDepth, rightDepth) + 1
    }

    fun TreeNode.getRight(): Int {
        val leftDepth = left?.getLeft() ?: 0
        val rightDepth = right?.getRight() ?: 0
        return maxOf(leftDepth, rightDepth) + 1
    }

}