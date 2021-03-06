package binary_tree

class InOrderRecursiveSolution {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val resultList = mutableListOf<Int>()
        root.getLeft(resultList)
        return resultList
    }

    fun TreeNode.getLeft(list: MutableList<Int>) {
        left?.getLeft(list)
        list.add(`val`)
        right?.getRight(list)
    }

    fun TreeNode.getRight(list: MutableList<Int>) {
        left?.getLeft(list)
        list.add(`val`)
        right?.getRight(list)
    }

}