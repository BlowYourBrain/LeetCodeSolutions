package binary_tree

class PostOrderRecursiveSolution {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val resultList = mutableListOf<Int>()
        root.getLeft(resultList)
        return resultList
    }

    fun TreeNode.getLeft(list: MutableList<Int>) {
        left?.getLeft(list)
        right?.getRight(list)
        list.add(`val`)
    }

    fun TreeNode.getRight(list: MutableList<Int>) {
        left?.getLeft(list)
        right?.getRight(list)
        list.add(`val`)
    }

}