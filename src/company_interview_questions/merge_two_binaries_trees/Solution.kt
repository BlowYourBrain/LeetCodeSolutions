package company_interview_questions.merge_two_binaries_trees

import binary_tree.TreeNode

//https://leetcode.com/problems/merge-two-binary-trees

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return merge(root1, root2)
    }

    private fun merge(leftTree: TreeNode?, rightTree: TreeNode?): TreeNode? {
        if (leftTree != null || rightTree != null){
            val left = merge(leftTree?.left, rightTree?.left)
            val right = merge(leftTree?.right, rightTree?.right)
            val node = TreeNode(leftTree.getValue() + rightTree.getValue())
            node.left = left
            node.right = right
            return node
        }

        return null
    }

    private fun TreeNode?.getValue(): Int = this?.`val` ?: 0

}