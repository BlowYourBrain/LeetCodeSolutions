package binary_tree

//var ti = TreeNode(5)
//var v = ti.`val`
//Definition for a binary tree node.

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

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