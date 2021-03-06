package binary_tree

class RecursiveSolution {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val resultList = mutableListOf<Int>()
        root.getLeft(resultList)
        return resultList
    }

    fun TreeNode.getLeft(list: MutableList<Int>) {
        list.add(`val`)
        left?.getLeft(list)
        right?.getRight(list)
    }

    fun TreeNode.getRight(list: MutableList<Int>) {
        list.add(`val`)
        left?.getLeft(list)
        right?.getRight(list)
    }

}