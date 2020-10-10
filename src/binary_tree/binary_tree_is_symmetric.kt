package binary_tree


class IsSymmetricSolution {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return isSymmetric(root.left, root.right)
    }

    private fun isSymmetric(nodeA: TreeNode?, nodeB: TreeNode?): Boolean {
        if (nodeA == null && nodeB == null) {
            return true
        }

        if (nodeA == null || nodeB == null) {
            return false
        }

        val isSymmetric = nodeA.`val` == nodeB.`val`

        if (!isSymmetric) {
            return false
        }

        val leftAndRightNodes = isSymmetric(nodeA.left, nodeB.right)
        if (!leftAndRightNodes) {
            return false
        }

        val rightAndLeftNodes = isSymmetric(nodeA.right, nodeB.left)
        if (!rightAndLeftNodes) {
            return false
        }

        return true
    }

}